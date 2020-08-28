package com.hy.crm.service.impl;

import com.hy.crm.entity.ForumReply;
import com.hy.crm.mapper.ForumReplyMapper;
import com.hy.crm.service.IForumReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 回复表 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
@Transactional
public class ForumReplyServiceImpl extends ServiceImpl<ForumReplyMapper, ForumReply> implements IForumReplyService {

}