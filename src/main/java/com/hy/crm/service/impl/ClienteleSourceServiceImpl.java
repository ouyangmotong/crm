package com.hy.crm.service.impl;

import com.hy.crm.entity.ClienteleSource;
import com.hy.crm.mapper.ClienteleSourceMapper;
import com.hy.crm.service.IClienteleSourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 客户来源表 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
@Transactional
public class ClienteleSourceServiceImpl extends ServiceImpl<ClienteleSourceMapper, ClienteleSource> implements IClienteleSourceService {

}
