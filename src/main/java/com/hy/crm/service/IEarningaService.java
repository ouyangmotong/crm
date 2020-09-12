package com.hy.crm.service;

import com.hy.crm.entity.Earninga;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 收入表 服务类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
public interface IEarningaService extends IService<Earninga> {

    //根据合同id查询当已收入金额
    Integer queryEarningNum(Integer contractId);

    //保存
    void saveEarning(Earninga earninga);

}
