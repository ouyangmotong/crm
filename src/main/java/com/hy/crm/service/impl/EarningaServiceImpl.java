package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Contract;
import com.hy.crm.entity.Earninga;
import com.hy.crm.mapper.EarningaMapper;
import com.hy.crm.service.IContractService;
import com.hy.crm.service.IEarningaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 收入表 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
@Transactional
public class EarningaServiceImpl extends ServiceImpl<EarningaMapper, Earninga> implements IEarningaService {
    @Autowired
    private IContractService contractService;


    /**
     * 根据合同id查询当已收入金额
     * @param contractId 合同id
     * @return
     */
    @Override
    public Integer queryEarningNum(Integer contractId){
        Integer earningNum = 0;//已收入金额
        QueryWrapper qw = new QueryWrapper();
        qw.eq("contract_id",contractId);
        List<Earninga> elist = list(qw);
        for(Earninga earninga : elist){
            earningNum += earninga.getEarningNum();
        }
        return earningNum;
    }

    /**
     * 保存
     * @param earninga
     */
    @Override
    public void saveEarning(Earninga earninga){
        Contract contract = contractService.getById(earninga.getContractId());//根据id查询出合同
        Integer earningNum = queryEarningNum(earninga.getContractId());//已收入金额
        if((earningNum + earninga.getEarningNum()) <= contract.getContractSum()){//已收入金额+待收入金额 小于等于 合同金额
            save(earninga);
        }
    }

}
