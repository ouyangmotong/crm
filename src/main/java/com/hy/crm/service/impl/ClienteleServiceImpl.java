package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectPage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.*;
import com.hy.crm.mapper.*;
import com.hy.crm.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 客户表 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
@Transactional
public class ClienteleServiceImpl extends ServiceImpl<ClienteleMapper, Clientele> implements IClienteleService {

    @Autowired
    private ClienteleMapper clienteleMapper;

    @Autowired
    private AfterSalesMapper afterSalesMapper;//售后服务数

    @Autowired
    private BusinessMapper businessMapper;//商机数

    @Autowired
    private ContractMapper contractMapper;//合同数

    @Autowired
    private EarningaMapper earningaMapper;//回款金额

    @Override
    public IPage<Assist> selectClient(int page,int limit,Clientele clientele){
        List<Assist> list=new ArrayList<>();
        IPage<Clientele> p = new Page<Clientele>(page, limit);
        IPage<Clientele> ipage=null;
                QueryWrapper queryWrapper=new QueryWrapper();
                if(clientele.getClienteleId()==null && clientele.getClienteleId()==null){
                    ipage=clienteleMapper.selectPage(p,null);
                }

                if(clientele.getClienteleId()!=null){
                    queryWrapper.eq("clientele_id",clientele.getClienteleId());
                    ipage=clienteleMapper.selectPage(p,queryWrapper);
                }
                if(clientele.getClienteleName()!=null){
                    queryWrapper.like("clientele_name",clientele.getClienteleName());
                    ipage=clienteleMapper.selectPage(p,queryWrapper);
                }
                if(clientele.getClienteleId()!=null && clientele.getClienteleName()!=null ){
                    queryWrapper.like("clientele_id",clientele.getClienteleId());
                    queryWrapper.or();
                    queryWrapper.like("clientele_name",clientele.getClienteleName());
                }
                List<Clientele> records = ipage.getRecords();
                IPage<Assist> IP=new Page<>();
                for(Clientele data:records){
                  Assist assist =selectBus(data.getClienteleId());
                  list.add(assist);
                }
                IP.setRecords(list);
                IP.setTotal(ipage.getTotal());
                return IP;
    }

    /***
     * 查询合同数
     * @param id
     */
     private Assist selectBus(int id){

        Assist assist=new Assist();
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("clientele_id",id);
        //查询所有的商机数
         List<Business> list = businessMapper.selectList(queryWrapper);
         for(Business a:list){
             assist.setClienteleName(a.getBusinessName());
             assist.setEstimatedAmount(a.getEstimatedAmount());
         }
         assist.setAid(id);
         assist.setBusNum(list.size());
         //查询的所有合同数
         List<Contract> list1 = selectCont(id);
         for(Contract data:list1){
             assist.setContractSum(data.getContractSum());//合同金额
         }
         assist.setConsNum(list1.size());

         //返回所有服务数
         List<AfterSales> afterSales = selectAfterSales(id);
         for(AfterSales afterSales1:afterSales){
             assist.setServiceScore(afterSales1.getServiceScore());
         }
         assist.setSalesNum(afterSales.size());
         //返回所有的回款额
         int earningas = selectEarning(id);
         assist.setBackmoney(earningas);
         return assist;
     }

    /**
     * 查询合同数
     * @param id
     */
    private List<Contract> selectCont(int id){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("clientele_id",id);
        List<Contract> list = contractMapper.selectList(queryWrapper);
        return list;
    }

    /***
     * 查询所有合同数
     * @param id
     * @return
     */
    private List<AfterSales> selectAfterSales(int id){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("clientele_id",id);
        List<AfterSales> list = afterSalesMapper.selectList(queryWrapper);
        return list;


    }

    /***
     * 查询回款额
     * @param id
     * @return
     */
    private int selectEarning(int id){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("clientele_id",id);

        List<Earninga>list = earningaMapper.selectList(queryWrapper);
        int sum=0;
        for(Earninga sy:list){
            sum+=sy.getEarningNum();
        }
        return sum;
    }


}
