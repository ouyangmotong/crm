package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Flow;
import com.hy.crm.mapper.FlowMapper;
import com.hy.crm.service.IFlowService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kw
 * @version 1.0
 * @description处理流程类
 * @date 2020/9/11 9:27 星期五
 */
@Service
@Transactional
public class FlowServiceImpl extends ServiceImpl<FlowMapper,Flow> implements IFlowService {



}
