package com.hy.crm.kw.mapper;

import com.hy.crm.kw.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户登录 Mapper 接口
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
