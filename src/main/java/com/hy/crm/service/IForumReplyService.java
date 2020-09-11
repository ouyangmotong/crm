package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.Emp;
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

    //根据帖子id查询帖子及所有回复
    //public ForumBo queryByIdForumReply(Integer forumId);

    //根据id查询帖子
    public ForumBo queryByIdForumReply2(Integer forumId);

    //查询所有回复
    public List<ForumReplyBo> queryForumReplyBos(List<ForumReply> frlist);

    //添加评论/回复
    public void saveForumReply(Integer forumId, Integer replyId, String principalPart, Emp emp);

}
