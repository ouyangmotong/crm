package com.hy.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.entity.*;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商机表 服务类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
public interface IBusinessService extends IService<Business> {
    public IPage<AssistBusy> findById(Integer page, Integer limit, Integer id);
    //根据条件查询
    public List<AssistBusy> findAll(IPage<AssistBusy> page, AssistBusy assistBusy);
    //根据id查询商机信息
    public  BusyBean  findByIdBusy(Integer id);
    public int updateBusiness(Business business);//修改商机信息；
    public int updateClient(Clientele clientele);//修改客户信息
    public int updateEmp(Emp emp);//修改员工在商机表中的id


}
