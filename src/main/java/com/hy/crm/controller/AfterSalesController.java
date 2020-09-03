package com.hy.crm.controller;

import com.hy.crm.service.IAfterSalesService;
import com.hy.crm.util.LayUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 售后服务表 前端控制器
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@RestController
@RequestMapping("/crm/after-sales")
public class AfterSalesController {
    /**
     * 注入售后的service
     */
    @Autowired
    private IAfterSalesService iAfterSalesService;

    /**
     *
     * @param page
     * @param limit
     * @param kind 1按主题 2 按服务类型 3 按开始时间 4 按服务人员 5 按服务评分
     * @param content
     * @return
     */
    @RequestMapping("/queryAll.do")
    public LayUIData queryAll(int page,int limit,int kind,String content){
        System.out.println("page="+page+"------------limit="+limit);
        return iAfterSalesService.queryAll(page,limit,kind,content);
    }

}
