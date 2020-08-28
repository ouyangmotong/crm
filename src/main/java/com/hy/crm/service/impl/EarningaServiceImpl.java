package com.hy.crm.service.impl;

import com.hy.crm.entity.Earninga;
import com.hy.crm.mapper.EarningaMapper;
import com.hy.crm.service.IEarningaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 收入表 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
@Transactional
public class EarningaServiceImpl extends ServiceImpl<EarningaMapper, Earninga> implements IEarningaService {

}
