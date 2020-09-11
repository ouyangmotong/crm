package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kw
 * @version 1.0
 * @description
 * @date 2020/9/3 8:39 星期四
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
