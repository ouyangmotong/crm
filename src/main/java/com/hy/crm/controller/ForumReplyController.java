package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.ForumReply;
import com.hy.crm.entity.bo.ForumBo;
import com.hy.crm.entity.bo.ForumReplyBo;
import com.hy.crm.service.IForumReplyService;
import com.hy.crm.service.IForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 回复表 前端控制器
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Controller
@RequestMapping("/crm/forum-reply")
public class ForumReplyController {
    @Autowired
    private IForumService forumService;
    @Autowired
    private IForumReplyService forumReplyService;

    /**
     * 查询帖子和相应的回复
     * @param forumId
     * @param model
     * @return
     */
    @RequestMapping("/queryByIdForumReply.do")
    public String queryByIdForumReply(Integer forumId, Model model){
        ForumBo forumBo = forumReplyService.queryByIdForumReply2(forumId);//查询主贴
        QueryWrapper qw = new QueryWrapper();
        qw.eq("forum_id",forumId);
        qw.eq("forum_reply_static",1001);//回复是可用状态
        List<ForumReplyBo> list = forumReplyService.queryForumReplyBos(forumReplyService.list(qw));//根据id查询所有回复
        forumBo.setForumReplyBoNum(forumReplyService.list(qw).size());//根据主贴id查询回复数
        model.addAttribute("forumBo",forumBo);
        model.addAttribute("list",list);
        return "/wry/queryForumReply.html";
    }

    /**
     * 添加评论/回复
     * @param forumId
     * @param replyId
     * @param principalPart
     * @param model
     * @return
     */
    @RequestMapping("/saveForumReply.do")
    public String saveForumReply(Integer forumId, Integer replyId, String principalPart, Model model){
        ForumReply fr = new ForumReply();
        fr.setForumId(forumId);
        fr.setPrincipalPart(principalPart);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
        fr.setFinallyDate(dateFormat.format(date));
        fr.setEmpId(1001);//写死了
        fr.setReplyId(replyId);//replyId 如果是-1就是评论 如果是有id就是回复评论
        fr.setForumReplyStatic(1001);
        forumReplyService.save(fr);
        return "redirect:queryByIdForumReply.do?forumId="+forumId;
    }

    /**
     * 刷新
     * @param forumId
     * @return
     */
    @RequestMapping("/flush.do")
    public String flush(Integer forumId){
        return "redirect:queryByIdForumReply.do?forumId="+forumId;
    }

}
