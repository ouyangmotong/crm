package com.hy.crm.controller;

import com.hy.crm.entity.AfterSales;
import com.hy.crm.entity.bo.AfterSalesBo;
import com.hy.crm.service.IAfterSalesService;
import com.hy.crm.util.ImgUtils;
import com.hy.crm.util.LayUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * <p>
 * 售后服务表 前端控制器
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Controller
@RequestMapping("/crm/after-sales")
public class AfterSalesController {
    /**
     * 注入售后的service
     */
    @Autowired
    private IAfterSalesService iAfterSalesService;

    /**
     *查询所有的售后信息
     * @param page
     * @param limit
     * @param kind 1按主题 2 按服务类型 3 按开始时间 4 按服务人员 5 按服务评分
     * @param content
     * @return
     */
    @RequestMapping("/queryAll.do")
    @ResponseBody
    public LayUIData queryAll(int page,int limit,int kind,String content){
        System.out.println("page="+page+"------------limit="+limit);
        return iAfterSalesService.queryAll(page,limit,kind,content);
    }

    /**
     * 先得到主题名字，根据主题名字查询主题对应的id，根据id查询该条数据
     *
     * @param id 主题名字
     */
    @RequestMapping("/queryById.do")
    public String queryById(String id, Model model) {
        AfterSalesBo afterSalesBo=iAfterSalesService.queryById(id);
        model.addAttribute("afterSales",afterSalesBo);
        return "afterSales";
    }

    /**
     * 添加售后服务
     * @param afterSales    售后的实体类
     * @param img   售后的附件
     * @param contractNo    合同的编号
     * @return
     */
    @PostMapping("/addAfterSales.do")
    public String addAfterSales(AfterSales afterSales,String img,String contractNo){
        System.out.println("img:"+img+"--contractNo："+contractNo);
        System.out.println("afterSales:"+afterSales);
        Boolean b=iAfterSalesService.addAfterSales(afterSales,img,contractNo);
        if(b == true){
            return "redirect:/html/querycontract.html";
        }
        return "error";
    }

    @RequestMapping("/fileUpload.do")
    @ResponseBody
    public ImgUtils fileUpload(@RequestParam("file") MultipartFile pictureFile, HttpServletRequest request) throws IOException {
        System.out.println("进fileupload----");
        // 图片上传设置图片名称，不能重复，可以使用uuid
        String picName = UUID.randomUUID().toString();
        // 获取文件名
        String oriName = pictureFile.getOriginalFilename();
        // 获取图片后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));

        String webpath = request.getServletContext().getRealPath("/");
        webpath = webpath.substring(0, webpath.lastIndexOf("\\"));
        webpath = webpath.substring(0, webpath.lastIndexOf("\\"));
        File rootFile = new File(webpath);
        File uploadFile = new File(rootFile, "upload");
        if (!uploadFile.exists()) {
            uploadFile.mkdir();
        }
        System.out.println("开始上传");
        // 开始上传
        pictureFile.transferTo(new File(webpath + File.separator + "upload" + File.separator + picName + extName));
        String imgName=File.separator + "upload" + File.separator + picName + extName;
        System.out.println("上传成功");
        ImgUtils imgUtils=new ImgUtils();
        imgUtils.setCode(0);
        imgUtils.setMsg("图片上传成功");
        imgUtils.setData(imgName);
        return imgUtils;
    }

}
