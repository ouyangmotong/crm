package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Contract;
import com.hy.crm.entity.Emp;
import com.hy.crm.util.LayUIData;

import java.util.List;

/**
 * <p>
 * 合同表 服务类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
public interface IContractService extends IService<Contract> {
    //根据条件查询合同
    LayUIData queryContract(Integer page, Integer limit,Emp emp,Integer classify, Integer type, String typeValue,Integer belong);

    //新增合同前查询可新增的商机
    List<Business> queryBusinessContract();

    //添加合同
    void saveNewContract(Contract contract,Integer businessId,Emp emp);
}
