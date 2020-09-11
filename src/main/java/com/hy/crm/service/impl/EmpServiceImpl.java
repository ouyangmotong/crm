package com.hy.crm.service.impl;

import com.hy.crm.entity.Emp;
import com.hy.crm.mapper.EmpMapper;
import com.hy.crm.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
@Transactional
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public int insertEmp(Emp emp) {
        return empMapper.insertEmp(emp);
    }

    @Override
    public int insertRoleEmp(Integer empid, String roleName) {
        return empMapper.insertRoleEmp(empid,roleName);
    }

}
