package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.*;
import com.hy.crm.entity.bo.ContractBo;
import com.hy.crm.mapper.ContractMapper;
import com.hy.crm.service.*;
import com.hy.crm.util.LayUIData;
import com.hy.crm.util.TimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 合同表 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
@Transactional
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements IContractService {
    @Autowired
    private IEmpService empService;
    @Autowired
    private IBusinessService businessService;
    @Autowired
    private IEarningaService earningaService;
    @Autowired
    private IInvoiceService iInvoiceService;
    @Autowired
    private IClienteleService clienteleService;

    /**
     * 根据条件查询所有合同
     * @param page 当前页
     * @param limit 每页显示条数
     * @param emp 当前用户
     * @param classify 类型(1001本周新增,1002上周新增,1003本月新增,1004上月新增,1005本季度新增,1006上季度新增)
     * @param type 类型(1001按合同名称,1002按客户名称,1003按商机,1004按签约日期)
     * @param typeValue 类型的值
     * @param belong 属于 1001查询全部 1002查询我的跟单
     * @return
     */
    @Override
    public LayUIData queryContract(Integer page, Integer limit,Emp emp,Integer classify, Integer type, String typeValue,Integer belong){
        LayUIData layUIData = new LayUIData();
        QueryWrapper qw = new QueryWrapper();
        List<ContractBo> cblist = new ArrayList<>();//存查出来的所有数据
        Integer count = 0;//数据长度
        boolean queryNotNull = true;//默认条件查询查到了（在此功能中是）

        TimeUtil tu = new TimeUtil();
        if(classify != null && classify != 0){//等于0就是查询所有
            if(classify == 1001){//1001本周新增
                String[] s = tu.getThisWeek();
                qw.ge("sign_date",s[0]);//大于等于周一
                qw.le("sign_date",s[1]);//小于等于周日
            }else if(classify == 1002){//1002上周新增
                String[] s = tu.getLastWeek();
                qw.ge("sign_date",s[0]);//大于等于上周一
                qw.le("sign_date",s[1]);//小于等于上周日
            }else if(classify == 1003){//1003本月新增
                String[] s = tu.getThisMonth();
                qw.ge("sign_date",s[0]);//大于等于本月第一天
                qw.le("sign_date",s[1]);//小于等于本月最后一天
            }else if(classify == 1004){//1004上月新增
                String[] s = tu.getLastMonth();
                qw.ge("sign_date",s[0]);//大于等于前一个月第一天
                qw.le("sign_date",s[1]);//小于等于前一个月最后一天
            }else if(classify == 1005){//1005本季度新增
                String[] s = tu.getCurrentSeason();
                qw.ge("sign_date",s[0]);//大于等于本季度第一天
                qw.le("sign_date",s[1]);//小于等于本季度最后一天
            }else if(classify == 1006){//1006上季度新增
                String[] s = tu.getPrecedingQuarter();
                qw.ge("sign_date",s[0]);//大于等于前一个季度第一天
                qw.le("sign_date",s[1]);//小于等于前一个季度最后一天
            }
        }

        if(type != null && type != 0){
            if(type == 1001){//1001按合同名称
                qw.eq("contract_name",typeValue);
            }else if(type == 1002){//1002按客户名称
                qw.eq("clientele_name",typeValue);
                List<Clientele> clist = clienteleService.list(qw);
                if(clist.size() > 0){//能查出客户就可以按作者查询
                    List clienteleIds = new ArrayList<>();
                    for(Clientele c : clist){
                        clienteleIds.add(c.getClienteleId());
                    }
                    qw = new QueryWrapper<>();//清空查询条件
                        qw.in("clientele_id",clienteleIds);
                }else {
                    queryNotNull = false;//没有查到客户
                }
            }else if(type == 1003){//1003按商机名称
                qw.eq("business_name",typeValue);
                List<Business> blist = businessService.list(qw);
                if(blist.size() > 0){//能查出商机就可以按商机查
                    List bs = new ArrayList();
                    for(Business b : blist){
                        bs.add(b.getBusinessId());
                    }
                    qw = new QueryWrapper();
                    qw.in("business_id",bs);
                }else {
                    queryNotNull = false;//没有查到商机
                }
            }else if(type == 1004){//1004按签约日期
                qw.eq("sign_date",typeValue);
            }
        }

        if(belong == 1002){//只查我的
            qw.eq("emp_id",emp.getEmpId());
        }

        if(queryNotNull){//如果条件查询没查出条件，就不可能查出数据，直接返回空
            IPage iPage= page(new Page<Contract>(page, limit),qw);//分页查询
            count = (int)iPage.getTotal();
            for(Contract c : (List<Contract>)iPage.getRecords()){
                ContractBo contractBo = new ContractBo();
                BeanUtils.copyProperties(c , contractBo);//将f类里的值都存进forumBo类中

                //汇款额
                qw = new QueryWrapper();
                qw.eq("contract_id",c.getContractId());
                Integer earningNum = 0;//汇款额
                List<Earninga> earningaList = earningaService.list(qw);
                for(Earninga e : earningaList){
                    earningNum += e.getEarningNum();
                }
                contractBo.setEarningNum(earningNum);

                //开票额
                qw = new QueryWrapper();
                qw.eq("contract_id",c.getContractId());
                Integer address = 0;//开票额
                List<Invoice> invoiceList = iInvoiceService.list(qw);
                for(Invoice i : invoiceList){
                    address += i.getContractSum();
                }
                contractBo.setAddress(address);

                cblist.add(contractBo);
            }
        }

        layUIData.setCode(0);
        layUIData.setMsg("查询成功");
        layUIData.setCount(count);
        layUIData.setData(cblist);
        return layUIData;
    }

    /**
     * 新增合同前查询可新增的商机
     * @return
     */
    @Override
    public List<Business> queryBusinessContract(){
        List<Business> blist = new ArrayList<>();//存跟单状态为完成状态并且没有签过合同所有商机
        QueryWrapper qw = new QueryWrapper();
        qw.eq("documentary_id",1003);//1003为跟单完成状态
        for(Business b : (List<Business>) businessService.list(qw)){//查询跟单状态为完成状态的所有商机
            qw = new QueryWrapper();
            qw.eq("business_id",b.getBusinessId());
            if(getOne(qw) == null){//查询该商机是否签订过合同，没有签过的存进blist
                blist.add(b);
            }
        }
        return blist;
    }

    /**
     * 添加合同
     * @param contract
     * @param businessId
     * @param emp
     */
    @Override
    public void saveNewContract(Contract contract,Integer businessId,Emp emp){
        Business business = businessService.getById(businessId);
        contract.setBusinessId(businessId);
        Clientele clientele = clienteleService.getById(business.getClienteleId());
        //contract.setClienteleId(clientele.getClienteleId());
        contract.setClienteleId(1001);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        contract.setContractNo("C"+sdf.format(new Date()));

        contract.setDeptId(emp.getDeptId());
        contract.setEmpId(emp.getEmpId());
        contract.setContractStatic(1001);//完成状态

        save(contract);
    }

}
