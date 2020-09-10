package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.AfterSales;
import com.hy.crm.entity.Clientele;
import com.hy.crm.entity.Contract;
import com.hy.crm.entity.bo.AfterSalesBo;
import com.hy.crm.mapper.AfterSalesMapper;
import com.hy.crm.service.IAfterSalesService;
import com.hy.crm.service.IClienteleService;
import com.hy.crm.service.IContractService;
import com.hy.crm.util.LayUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 售后服务表 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
@Transactional
public class AfterSalesServiceImpl extends ServiceImpl<AfterSalesMapper, AfterSales> implements IAfterSalesService {

    /**
     * 注入售后的service
     */
    @Autowired
    private IAfterSalesService iAfterSalesService;

    /**
     * 注入合同service
     */
    @Autowired
    private IContractService iContractService;

    /**
     * 注入客户service
     */
    @Autowired
    private IClienteleService iClienteleService;

    @Override
    public LayUIData queryAll(int page,int limit,int kind,String content){
        LayUIData layUIData = new LayUIData();
        IPage iPage = new Page<AfterSales>(page, limit);
        QueryWrapper<AfterSales> queryWrapper=new QueryWrapper<>();
        if(!StringUtils.isEmpty(content) && !StringUtils.isEmpty(kind)){
            if(kind == 1){
                queryWrapper.like("headline",content);
            }else if(kind == 2){
                queryWrapper.like("service_classify",content);
            }else if(kind == 3){
                queryWrapper.like("begin_date",content);
            }else if(kind == 4){
                queryWrapper.like("service_staff",content);
            }else if(kind == 5){
                queryWrapper.like("service_score",content);
            }
        }
        IPage iPage1 = iAfterSalesService.page(iPage, queryWrapper);
        layUIData.setData(iPage1.getRecords());
        layUIData.setCode(0);
        layUIData.setCount((int) iPage1.getTotal());
        layUIData.setMsg("查询成功");
        return layUIData;
    }

    @Override
    public Boolean addAfterSales(AfterSales afterSales,String img,String contractNo){
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        String date=df.format(new Date());
        //根据合同编号查询合同的id
        QueryWrapper<Contract> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("contract_no",contractNo);
        Contract contract=iContractService.getOne(queryWrapper);
        //把得到的id赋值进去
        afterSales.setFile(img);
        //把查询出来的id赋值进去
        afterSales.setContractId(contract.getContractId());
        //添加最后修改时间
        afterSales.setLastTime(date);
        Boolean b=iAfterSalesService.save(afterSales);
        return b;
    }

    @Override
    public AfterSalesBo queryById(String id){
        AfterSalesBo afterSalesBo=new AfterSalesBo();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        QueryWrapper<AfterSales> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("headline",id);
        AfterSales afterSales = iAfterSalesService.getOne(queryWrapper);
        //主题
        afterSalesBo.setHeadline(afterSales.getHeadline());
        //状态(1001已登记待处理,1002处理中,1003结束)
        afterSalesBo.setAftStatic(afterSales.getAftStatic());
        //责任人
        afterSalesBo.setDutyPerson(afterSales.getDutyPerson());
        //参与人
        afterSalesBo.setParticipant(afterSales.getParticipant());
        //客户id afterSales.getClienteleId(),根据客户id查询客户信息
        if(!StringUtils.isEmpty(afterSales.getClienteleId())){
            Clientele clientele=iClienteleService.getById(afterSales.getClienteleId());
            //客户名字
            afterSalesBo.setClienteleName(clientele.getClienteleName());
        }
        //合同id afterSales.getContractId()，根据合同id查询合同信息
        if (!StringUtils.isEmpty(afterSales.getContractId())){
            Contract contract=iContractService.getById(afterSales.getContractId());
            //合同编号
            afterSalesBo.setContractId(contract.getContractNo());
        }
        //合同主要内容
        afterSalesBo.setContractContent(afterSales.getContractContent());
        //对方联系人
        afterSalesBo.setContacts(afterSales.getContacts());
        //固定电话
        afterSalesBo.setTelephone(afterSales.getTelephone());
        //移动电话
        afterSalesBo.setPhone(afterSales.getPhone());
        //邮件/QQ
        afterSalesBo.setEmail(afterSales.getEmail());
        //服务类型(1001故障申报、1002业务咨询、1003实施或培训、1004主动关怀、1005其他)
        afterSalesBo.setServiceClassify(afterSales.getServiceClassify());
        //服务方式
        afterSalesBo.setClassifyType(afterSales.getClassifyType());
        //开始时间
        Date beginDate=afterSales.getBeginDate();
        afterSalesBo.setBeginDate(formatter.format(beginDate));
        //结束时间
        Date endDate=afterSales.getEndDate();
        afterSalesBo.setEndDate(formatter.format(endDate));
        //服务内容
        afterSalesBo.setServiceContent(afterSales.getServiceContent());
        //客户反馈
        afterSalesBo.setCustomerFeedback(afterSales.getCustomerFeedback());
        //服务人员
        afterSalesBo.setServiceStaff(afterSales.getServiceStaff());
        //服务评分
        afterSalesBo.setServiceScore(afterSales.getServiceScore());
        //附件
        afterSalesBo.setFile(afterSales.getFile());
        return afterSalesBo;
    }
}
