package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.Assist;
import com.hy.crm.entity.Clientele;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.utils.MoveSqlMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 * 客户表 Mapper 接口
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Mapper
public interface ClienteleMapper extends BaseMapper<Clientele> {

    @SelectProvider(type=MoveSqlMapper.class,method="find")
    public List<Clientele> select(IPage<Assist> page, @Param("as")Clientele assist);
    @Select("select * from clientele")
    public List<Clientele> selectTo(IPage<Clientele> page, @Param("as")Clientele assist);



}
