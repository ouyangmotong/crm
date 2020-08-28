package com.hy.crm.kw.service.impl;

import com.hy.crm.kw.entity.User;
import com.hy.crm.kw.mapper.UserMapper;
import com.hy.crm.kw.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
