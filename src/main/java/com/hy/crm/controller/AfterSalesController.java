package com.hy.crm.controller;


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

    @RequestMapping("/select.do")
    public String select(){
        System.out.println("========");
        return "aaaa";
    }

}
