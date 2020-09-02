package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.ForumReply;
import com.hy.crm.entity.bo.ForumBo;

/**
 * <p>
 * 回复表 服务类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
public interface IForumReplyService extends IService<ForumReply> {
    public ForumBo queryByIdForumReply(Integer forumId);

}
