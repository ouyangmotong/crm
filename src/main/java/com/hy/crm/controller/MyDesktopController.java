package com.hy.crm.controller;

import com.hy.crm.service.IMyDesktopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jackson
 * @date 2020/9/11 18:07
 * @Description:
 */
@Controller
@RequestMapping("/crm/mydesktop")
public class MyDesktopController {
    @Autowired
    private IMyDesktopService myDesktopService;
    /**
     * 查询我的桌面所需的数据
     */
    @RequestMapping("/queryNum.do")
    public void queryNum(){
        myDesktopService.queryNum();
    }
}
