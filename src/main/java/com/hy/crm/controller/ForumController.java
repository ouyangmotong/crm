package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Forum;
import com.hy.crm.service.impl.EmpServiceImpl;
import com.hy.crm.util.LayUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 论坛表 前端控制器
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@RestController
@RequestMapping("/crm/forum")
public class ForumController {
    /*@Autowired
    private ForumServiceImpl forumService;*/
    @Autowired
    private EmpServiceImpl empService;

    @ResponseBody
    @RequestMapping("/queryForum.do")
    public LayUIData queryForum(int page, int limit/*, Forum forum*/){
        LayUIData layUIData = new LayUIData();
        QueryWrapper<Forum> queryWrapper = new QueryWrapper<>();
        System.out.println(123);
        /*if(!StringUtils.isEmpty(forum)){
            if(!StringUtils.isEmpty(emp.getEname())){
                queryWrapper.eq("ename",emp.getEname());
            }
            if (!StringUtils.isEmpty(emp.getDeptno())){
                queryWrapper.eq("deptno",emp.getDeptno());
            }
        }*/
        //分页查询
        /*IPage iPage= forumService.page(new Page<Forum>(page, limit),queryWrapper);
        layUIData.setCode(0);
        layUIData.setMsg("查询成功");
        layUIData.setCount((int)iPage.getTotal());
        layUIData.setData(iPage.getRecords());
        System.out.println("查询成功!");*/
        return layUIData;
    }

}
