package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.ApplyInvoice;
import com.hy.crm.mapper.ApplyInvoiceMapper;
import com.hy.crm.service.IApplyInvoiceService;
import com.hy.crm.service.IEarningaService;
import com.hy.crm.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 开票申请表 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
@Transactional
public class ApplyInvoiceServiceImpl extends ServiceImpl<ApplyInvoiceMapper, ApplyInvoice> implements IApplyInvoiceService {
    @Autowired
    private IInvoiceService iInvoiceService;
    @Autowired
    private IEarningaService earningaService;

    /**
     * 根据合同查询该合同下待审核的开票申请
     * @param contractId 合同id
     * @return
     */
    @Override
    public Integer queryApplyInvoiceNum(Integer contractId){
        Integer applyInvoiceNum = 0;//待审额
        QueryWrapper qw = new QueryWrapper();
        qw.eq("contract_id",contractId);
        qw.eq("invoice_static",1001);//1001待审核状态
        List<ApplyInvoice> ailist = list(qw);
        for(ApplyInvoice ai : ailist){
            if(ai.getContractSum() != null){
                applyInvoiceNum += ai.getContractSum();
            }
        }
        return applyInvoiceNum;
    }

    /**
     * 添加
     * @param applyInvoice
     * @param accountBank 开户行名称
     * @param bankAccount 开户账号
     * @param bankAddress 开户行地址
     * @param companyTelephone 开户行电话
     */
    public void saveApplyInvoice(ApplyInvoice applyInvoice,String accountBank,String bankAccount,String bankAddress,String companyTelephone){

        //收入额
        Integer earningNum = earningaService.queryEarningNum(applyInvoice.getContractId());//回款额

        //已开票额
        Integer address = iInvoiceService.queryAddress(applyInvoice.getContractId());//开票额

        //待审额
        Integer applyInvoiceNum = queryApplyInvoiceNum(applyInvoice.getContractId());//待审额

        //新待开票金额+已开票金额+待审核金额 不能大于 已收入金额
        if((applyInvoice.getContractSum() + address + applyInvoiceNum) <= earningNum){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            applyInvoice.setApplyDate(sdf.format(new Date()));//申请日期

            applyInvoice.setCardNumber(accountBank+""+bankAccount);//开户行银行卡账号
            applyInvoice.setAddress(bankAddress+""+companyTelephone);//地址电话

            if(applyInvoice.getPriorityId() != null){//优先级
                if(applyInvoice.getPriorityId() == 1){
                    applyInvoice.setPriorityId(1001);
                }else if(applyInvoice.getPriorityId() == 2){
                    applyInvoice.setPriorityId(1002);
                }
                else if(applyInvoice.getPriorityId() == 3){
                    applyInvoice.setPriorityId(1003);
                }
            }

            applyInvoice.setInvoiceStatic(1001);//1001为待审核状态

            save(applyInvoice);
        }

        //earningaService.save(earninga);
    }

}
