package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.AfterSales;
import com.hy.crm.entity.bo.AfterSalesBo;
import com.hy.crm.util.LayUIData;

/**
 * <p>
 * 售后服务表 服务类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
public interface IAfterSalesService extends IService<AfterSales> {
    LayUIData queryAll(int page, int limit, int kind, String content);
    Boolean addAfterSales(AfterSales afterSales,String img,String contractNo);
    AfterSalesBo queryById(String id);
}
