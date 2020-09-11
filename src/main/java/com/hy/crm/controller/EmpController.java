package com.hy.crm.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.Emp;
import com.hy.crm.entity.Role;
import com.hy.crm.service.IEmpService;
import com.hy.crm.utils.MsgTool;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Controller
@RequestMapping("/crm/emp")
public class EmpController {
    @Autowired
    private IEmpService empIService;


    @RequestMapping(value="/testLogin",method = RequestMethod.POST)
    @ResponseBody
    public MsgTool  testLogin(@RequestParam(value="username",required=false) String username, @RequestParam(value="password",required=false) String password, @RequestParam(value="remeberme",required=false) String remeberme){
        //创建subject主体
        Subject subject = SecurityUtils.getSubject();
        //创建信息异常处理对象
        MsgTool ms=new MsgTool();
        //创建UserNamePasswordToken对象将密码封装给对象
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        if(remeberme!=null && "1".equals(remeberme)){
            //用于记住用户
            token.setRememberMe(true);
        }
        subject.login(token);
        ms.setCode(200);
        ms.setMsg("登录成功！");
        return ms;
    }

    /***
     * 员工注册页面
     * @param emp
     * @return
     */
    @RequestMapping(value="/register.do",method=RequestMethod.POST)
    @ResponseBody
    public  MsgTool register(@RequestBody Emp emp){
        //创建消息提示对象
        MsgTool mg=new MsgTool();
        //对密码进行采用MD5算法加密
        String hashAlgorithName="MD5";
        Object credentials=emp.getEmpPwd();
        //加盐
        Object salt= ByteSource.Util.bytes(emp.getEmpName());
        //加密次数
        int hashIterations=1024;
        Role r=new Role();
        //进行加密
        String simpleHash = new SimpleHash(hashAlgorithName, credentials, salt, hashIterations).toString();
        emp.setEmpPwd( simpleHash);
        int  b = empIService.insertEmp(emp);
        int id=emp.getEmpId();
        if(b>0){
            empIService.insertRoleEmp(id,"");
            mg.setCode(200);
            mg.setMsg("添加成功");
        }else{
            mg.setCode(403);
            mg.setMsg("添加失败");
        }
        return mg;
    }

    /**
     * 退出系统
     * @return
     */
    @GetMapping("/lginOut")
    public String loginOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/temp/login.html";

    }

    /***
     *
     * 头像上传
     * @param multipartFile
     * @param httpServletRequest
     */
    @PostMapping("/fileUpload")
    @ResponseBody
    public MsgTool fileUpload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest httpServletRequest){
            //创建消息提示对象
            MsgTool mg=new MsgTool();
        try {
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

        } catch (IOException e) {
            mg.setCode(403);
            mg.setMsg("上传失败");
            e.printStackTrace();
        }

        return mg;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "-----";
    }

}
