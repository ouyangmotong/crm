package com.hy.crm.service;

import com.hy.crm.entity.ApplyInvoice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 开票申请表 服务类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
public interface IApplyInvoiceService extends IService<ApplyInvoice> {

    //根据合同查询该合同下待审核的开票申请
    Integer queryApplyInvoiceNum(Integer contractId);

    //添加
    void saveApplyInvoice(ApplyInvoice applyInvoice,String accountBank,String bankAccount,String bankAddress,String companyTelephone);
}
