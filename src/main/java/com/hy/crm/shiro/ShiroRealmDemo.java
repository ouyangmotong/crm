package com.hy.crm.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Emp;
import com.hy.crm.mapper.EmpMapper;
import com.hy.crm.service.IEmpService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author kw
 * @version 1.0
 * @description
 * @date 2020/9/1 10:53 星期二
 */

public class ShiroRealmDemo extends AuthorizingRealm {
    @Autowired
    private EmpMapper empMapper;

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取认证对象
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        //获取登录的用户名
        String userName = upToken.getUsername();
        System.out.println("userName="+userName);
        //获取用户登录的密码
        String password = new String(upToken.getPassword());
        System.out.println("password="+password);
        //利用登录用户名，查询数据库
        List<Emp> list = empMapper.findByName(userName);

        if (list == null || list.size() == 0) {
            throw new UnknownAccountException("此用户不存在！");
        }
        Emp emp = list.get(0);
        //获取盐值加密
        ByteSource salt = ByteSource.Util.bytes(userName);
        /*String md = new SimpleHash("MD5", password, salt, 1024).toString();
        System.out.println(md);*/
        if(!emp.getEmpName().equals(userName)){
            throw new UnknownAccountException("没有此用户");
        }

        System.out.println("认证成功.....");
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(emp.getEmpName(),emp.getEmpPwd(),salt,getName());
        return authenticationInfo;

    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
    }
}