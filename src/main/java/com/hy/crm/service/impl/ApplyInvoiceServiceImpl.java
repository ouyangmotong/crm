package com.hy.crm.service.impl;

import com.hy.crm.entity.ApplyInvoice;
import com.hy.crm.mapper.ApplyInvoiceMapper;
import com.hy.crm.service.IApplyInvoiceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
