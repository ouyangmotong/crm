package com.hy.crm.controller;

import com.hy.crm.entity.Forum;
import com.hy.crm.service.IForumService;
import com.hy.crm.util.LayUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 论坛表 前端控制器
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Controller
@RequestMapping("/crm/forum")
public class ForumController {
    @Autowired
    private IForumService forumService;

    /**
     * 按条件分页查询所有帖子
     * @param page 当前页
     * @param limit 每页显示条数
     * @param dept 条件编号
     * @param name 条件内容
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryForum.do")
    public LayUIData queryForum(Integer page, Integer limit, Integer dept, String name){
        return forumService.queryForum(page,limit,dept,name);
    }

    /**
     * 发帖
     * @param forum
     * @return
     */
    @RequestMapping("/saveForum.do")
    public String saveForum(Forum forum){
        forum.setEmpId(1001);//没有当前用户id，给个默认值
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
        forum.setForumDate(dateFormat.format(date));//发帖时间
        forum.setForumClicks(0);//点击量0
        forum.setForumStatic(1001);//状态 1001成功
        forumService.save(forum);
        return "redirect:../../wry/queryForum.html";
    }

}
