package com.hy.crm.controller;

import com.hy.crm.entity.bo.ForumBo;
import com.hy.crm.service.IForumReplyService;
import com.hy.crm.service.IForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/queryByIdForumReply.do")
    public String queryByIdForumReply(Integer forumId, Model model){
        ForumBo forumBo = forumReplyService.queryByIdForumReply(forumId);
        model.addAttribute("forumBo",forumBo);
        return "/wry/queryForumReply.html";
    }

}
