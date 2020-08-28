package com.hy.crm.service.impl;

import com.hy.crm.entity.Forum;
import com.hy.crm.mapper.ForumMapper;
import com.hy.crm.service.IForumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 论坛表 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
@Transactional
public class ForumServiceImpl extends ServiceImpl<ForumMapper, Forum> implements IForumService {

}
