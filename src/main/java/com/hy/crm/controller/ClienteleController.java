package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.Assist;
import com.hy.crm.entity.ClientAssist;
import com.hy.crm.entity.Clientele;
import com.hy.crm.entity.Emp;
import com.hy.crm.mapper.SqlMapper;
import com.hy.crm.service.IClienteleService;
import com.hy.crm.service.ISqlService;
import com.hy.crm.utils.MsgMag;
import com.hy.crm.utils.MsgTool;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 客户表 前端控制器
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Controller
@RequestMapping("/crm/clientele")
public class ClienteleController {
    @Autowired
    private IClienteleService clienteleService;

    @RequestMapping(value="/add",method= RequestMethod.POST)
    @ResponseBody
    public MsgTool add(@RequestBody Clientele clientele){
        //创建信息对象
        MsgTool ms=new MsgTool();
        boolean save = clienteleService.save(clientele);
        if(save){
            ms.setCode(200);
            ms.setMsg("添加成功！");
            ms.setData("");
        }else{
            ms.setCode(500);
            ms.setMsg("添加失败！");
            ms.setData("");
        }
        return ms;

    }
    @RequestMapping("/select")
    @ResponseBody
    public MsgMag select(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit,Clientele clientele){
        IPage<Assist> page1 = clienteleService.selectClient(page,limit,clientele);
        //创建消息管理对象
        MsgMag mm=new MsgMag();
        mm.setCode(0);
        mm.setMsg("查询成功！");
        mm.setCount((int)page1.getTotal());
        mm.setData(page1.getRecords());
        return mm;
    }

    /***
     *
     * 查询所有的客户名称
     * @return
     */

    @RequestMapping("/selecAllClientName")
    @ResponseBody
    public List<Clientele>  selectALLClientName(){
        List<Clientele> list = clienteleService.list(null);
        return list;
    }

    /*****
     *
     * 根据id查询当前用户
     * @param id
     */
    @RequestMapping("/findById")
    public String findById(String id,Model model){
        Clientele client = clienteleService.getById(id);
        model.addAttribute("client",client);
        return "/crm/temp/edit.html";

    }

    /***
     * 修改客户资料
     * @param clientele
     */
    @RequestMapping("/updateById")
    public String updateById(Clientele clientele){
        boolean bool= clienteleService.updateById(clientele);
        return "/temp/ctm.jsp";

    }



}
