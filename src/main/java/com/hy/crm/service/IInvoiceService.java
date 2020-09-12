package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.Invoice;

/**
 * <p>
 * 开票表 服务类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
public interface IInvoiceService extends IService<Invoice> {
    //根据合同id查询已开票金额
    Integer queryAddress(Integer contractId);
}
