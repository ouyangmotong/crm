package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.Documentary;
import com.hy.crm.util.LayUIData;

/**
 * <p>
 * 商机状态(跟单) 服务类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
public interface IDocumentaryService extends IService<Documentary> {
    public LayUIData queryDocumentary(Integer page, Integer limit, Integer dept, String name);

}
