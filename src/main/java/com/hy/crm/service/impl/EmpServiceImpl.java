package com.hy.crm.service.impl;

import com.hy.crm.entity.Emp;
import com.hy.crm.mapper.EmpMapper;
import com.hy.crm.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

}
