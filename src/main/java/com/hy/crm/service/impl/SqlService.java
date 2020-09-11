package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Assist;
import com.hy.crm.mapper.SqlMapper;
import com.hy.crm.service.ISqlService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author kw
 * @version 1.0
 * @description
 * @date 2020/9/4 18:12 星期五
 */
@Service
@Transactional
public class SqlService  extends ServiceImpl<SqlMapper, Assist> implements ISqlService {

}
