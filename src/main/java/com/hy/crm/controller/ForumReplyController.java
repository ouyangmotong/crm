package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Emp;
import com.hy.crm.entity.bo.ForumBo;
import com.hy.crm.entity.bo.ForumReplyBo;
import com.hy.crm.service.IForumReplyService;
import com.hy.crm.service.IForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
     * @param forumId 帖子id
     * @param model
     * @return
     */
    @RequestMapping("/queryByIdForumReply.do")
    public String queryByIdForumReply(Integer forumId, Model model){
        ForumBo forumBo = forumReplyService.queryByIdForumReply2(forumId);//查询主贴
        QueryWrapper qw = new QueryWrapper();

        qw.eq("forum_id",forumId);//主贴id
        qw.eq("forum_reply_static",1001);//回复是可用状态
        List<ForumReplyBo> list = forumReplyService.queryForumReplyBos(forumReplyService.list(qw));//根据主贴id和状态是1001(成功|可用)查询所有回复

        qw = new QueryWrapper();
        qw.eq("forum_id",forumId);//主贴id
        forumBo.setForumReplyBoNum(forumReplyService.list(qw).size());//根据主贴id查询回复数

        model.addAttribute("forumBo",forumBo);//返回给前端的主贴信息
        model.addAttribute("list",list);//返回给前端的回复信息
        return "/wry/queryForumReply.html";
    }

    /**
     * 添加评论/回复
     * @param forumId 帖子id
     * @param replyId 回复回复id
     * @param principalPart 回复内容
     * @param model
     * @return
     */
    @RequestMapping("/saveForumReply.do")
    public String saveForumReply(Integer forumId, Integer replyId, String principalPart, Model model, HttpSession session){
        Emp emp = new Emp();
        //emp = (Emp) session.getAttribute("emp");//当前用户
        emp.setEmpId(1001);//写死
        forumReplyService.saveForumReply(forumId,replyId,principalPart,emp);
        return "redirect:queryByIdForumReply.do?forumId="+forumId;//回复成功后重定向到根据id查询帖子级回复页面
    }

}
