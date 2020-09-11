package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.Documentary;
import com.hy.crm.entity.Emp;
import com.hy.crm.entity.bo.DocumentaryBo;
import com.hy.crm.util.LayUIData;

import java.util.List;

/**
 * <p>
 * 商机状态(跟单) 服务类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
public interface IDocumentaryService extends IService<Documentary> {

    //根据条件分页查询所有|我的跟单
    LayUIData queryDocumentary(Integer page, Integer limit, Integer type, String typeValue, Integer belong, Emp emp);

    //根据商机id查询跟单信息
    List<DocumentaryBo> queryBusinessById(String businessId);

    //继续跟单
    void saveDocumentary(Documentary documentary,Integer businessStatic);

    //新增跟单
    void saveNewDocumentary(Documentary documentary,Integer businessId,Integer businessStatic,Emp emp);

}
