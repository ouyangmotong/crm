package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.*;
import com.hy.crm.service.IBusinessService;
import com.hy.crm.service.IClienteleService;
import com.hy.crm.service.IFlowService;
import com.hy.crm.service.IIndustryService;
import com.hy.crm.utils.MsgMag;
import com.hy.crm.utils.MsgTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 商机表 前端控制器
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Controller
@RequestMapping("/crm/business")
public class BusinessController {
    @Autowired
    private IBusinessService businessService;
    @Autowired
    private IClienteleService clienteleService;
    @Autowired
    private IIndustryService industryService;
    @Autowired
    private IFlowService flowService;
    /***
     * 查询商机信息
     * @param id
     */
    @RequestMapping("/findById")
    @ResponseBody
    public MsgMag findById(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit,@RequestParam("id") Integer id){
        MsgMag msg=new MsgMag();
        IPage<AssistBusy> byId = businessService.findById(page,limit,id);
        msg.setCode(0);
        msg.setMsg("查询成功");
        msg.setCount((int)byId.getTotal());
        msg.setData(byId.getRecords());
        return msg;
    }

    /**
     * 查询所有商机
     * @param assistBusy
     * @return
     */

    @RequestMapping("/findAll")
    @ResponseBody
    public MsgMag findAll(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit,AssistBusy assistBusy){
        MsgMag msg=new MsgMag();
        IPage<AssistBusy> iPage=new Page();
        List<AssistBusy> list = businessService.findAll(iPage,assistBusy);
        msg.setCode(0);
        msg.setMsg("查询成功");
        msg.setCount((int)iPage.getTotal());
        msg.setData(list);
        return msg;
    }

    /***
     * 新增商机
     * @param business
     * @param clientele
     */
    @RequestMapping(value="/save",method = RequestMethod.POST)
    @ResponseBody
    public MsgTool  save(Business business, Clientele clientele, Industry industry){
        MsgTool msg=new MsgTool();
        boolean save = businessService.save(business);
        boolean save1 = clienteleService.save(clientele);
        boolean save2 = industryService.save(industry);
        msg.setCode(200);
        msg.setMsg("保存成功!");
        return msg;

    }

    /***
     *
     * 上传文件
     * @param multipartFile
     * @param httpServletRequest
     */

    @PostMapping("/uploadFile")
    @ResponseBody
    public  MsgTool uploadFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest httpServletRequest){
        //创建消息处理对象
        MsgTool mg=new MsgTool();
        try{
            //设置文件名称
            String uuid= UUID.randomUUID().toString().substring(0,8);
            //获取项目根路径
            String path = httpServletRequest.getServletContext().getRealPath("/crm");
            //获取文件名称
            String filename = multipartFile.getOriginalFilename();
            //获取文件后缀名称
            String suffixName=filename.substring(filename.lastIndexOf("."));
            //设置图片上传路径
            File file=new File(path+"/img");

            if(!file.exists()){
                file.mkdir();
            }else{
                System.out.println("文件目录已存在！");
            }
            //开始文件上传
            multipartFile.transferTo(new File(file+"/"+uuid+suffixName));
            mg.setCode(200);
            mg.setMsg("上传成功！");
            mg.setData("/img"+"/"+uuid+suffixName);

        }catch (IOException e){
            e.printStackTrace();
            mg.setCode(200);
            mg.setMsg("上传失败！");
            mg.setData("");

        }

        return mg;

    }

    /***
     * 根据id查询
     * @param id
     */
    @RequestMapping("/select")
    public String select(@RequestParam("id") Integer id,Model model){
        BusyBean arg = businessService.findByIdBusy(id);
        model.addAttribute("data",arg);
        return "/temp/EAB.html";

    }

    /***
     * 修改商机
     * @param business
     * @param clientele
     * @return
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    public String  update(Business business,Clientele clientele,Emp emp){
            System.out.println("business"+business+"=="+clientele+"emp="+emp);
            businessService.updateBusiness(business);
            businessService.updateClient(clientele);
            businessService.updateEmp(emp);
            return"/crm/crm/business.jsp";

    }

    /***
     * 流程处理
     */
    @RequestMapping("/flow")
    @ResponseBody
    public MsgTool flow(Flow flow){
        //处理信息的类
        MsgTool msg=new MsgTool();
        boolean save = flowService.save(flow);
        msg.setCode(200);
        msg.setMsg("发送成功，正在审核....");
        msg.setData("");
        return msg;
    }



}
