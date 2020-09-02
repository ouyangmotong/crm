package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.ForumReply;
import com.hy.crm.entity.bo.ForumBo;
import com.hy.crm.entity.bo.ForumReplyBo;

import java.util.List;

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
    public ForumBo queryByIdForumReply2(Integer forumId);
    public List<ForumReplyBo> queryForumReplyBos(List<ForumReply> frlist);

}
