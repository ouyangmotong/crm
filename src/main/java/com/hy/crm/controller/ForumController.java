package com.hy.crm.controller;

import com.hy.crm.service.IEmpService;
import com.hy.crm.service.IForumService;
import com.hy.crm.util.LayUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    private IEmpService empService;

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
}
