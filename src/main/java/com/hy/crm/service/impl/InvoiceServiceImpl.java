package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Invoice;
import com.hy.crm.mapper.InvoiceMapper;
import com.hy.crm.service.IInvoiceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 开票表 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
@Transactional
public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice> implements IInvoiceService {

    /**
     * 根据合同id查询已开票金额
     * @param contractId
     * @return
     */
    @Override
    public Integer queryAddress(Integer contractId){
        Integer address = 0;//开票额
        QueryWrapper qw = new QueryWrapper();
        qw.eq("contract_id",contractId);
        List<Invoice> invoiceList = list(qw);
        for(Invoice i : invoiceList){
            address += i.getContractSum();
        }
        return address;
    }

}
