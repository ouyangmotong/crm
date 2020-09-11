package com.hy.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.Assist;
import com.hy.crm.entity.ClientAssist;
import com.hy.crm.entity.Clientele;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.mapper.ClienteleMapper;
import com.hy.crm.utils.MoveSqlMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 * 客户表 服务类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
public interface IClienteleService extends IService<Clientele> {

    public IPage<Assist> selectClient(int page,int limit, Clientele clientele);


}
