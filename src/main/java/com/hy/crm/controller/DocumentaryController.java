package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Documentary;
import com.hy.crm.entity.bo.DocumentaryBo;
import com.hy.crm.service.IBusinessService;
import com.hy.crm.service.IDocumentaryService;
import com.hy.crm.util.LayUIData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 跟單表 前端控制器
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Controller
@RequestMapping("/crm/documentary")
public class DocumentaryController {
    @Autowired
    private IDocumentaryService documentaryService;
    @Autowired
    private IBusinessService businessService;

    /**
     * 根据条件分页查询跟单
     * @param page
     * @param limit
     * @param dept
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryDocumentary.do")
    public LayUIData queryDocumentary(Integer page, Integer limit, Integer dept, String name){
        return documentaryService.queryDocumentary(page,limit,dept,name);
    }

    /**
     * 根据主题查询跟单信息
     * @param businessId
     * @return
     */
    @RequestMapping("/queryBusinessName.do")
    public String queryBusinessName(String businessId, Model model){
        QueryWrapper qw = new QueryWrapper();
        qw.eq("business_id",businessId);
        List<Documentary> dlist = documentaryService.list(qw);
        List<DocumentaryBo> dblist = new ArrayList<>();
        for (Documentary d : dlist){
            DocumentaryBo db = new DocumentaryBo();
            BeanUtils.copyProperties(d , db);
            if(d.getDocumentaryType() == 1001){//电话沟通
                db.setDocumentaryTypeName("电话沟通");
            }else if(d.getDocumentaryType() == 1002){//邮件联系
                db.setDocumentaryTypeName("邮件联系");
            }else if(d.getDocumentaryType() == 1003){//网上交流
                db.setDocumentaryTypeName("网上交流");
            }else if(d.getDocumentaryType() == 1004){//上面拜访
                db.setDocumentaryTypeName("上面拜访");
            }else if(d.getDocumentaryType() == 1005){//产品送样
                db.setDocumentaryTypeName("产品送样");
            }else if(d.getDocumentaryType() == 1006){//客户招待
                db.setDocumentaryTypeName("客户招待");
            }else if(d.getDocumentaryType() == 1007){//其他
                db.setDocumentaryTypeName("其他");
            }
            dblist.add(db);
        }
        model.addAttribute("dblist",dblist);
        model.addAttribute("documentaryBo",dblist.get(0));
        return "wry/queryDocumentary.html";
    }

    @RequestMapping("/saveDocumentary.do")
    public String saveDocumentary(Documentary documentary,Integer businessStatic){
        documentaryService.save(documentary);
        QueryWrapper qw = new QueryWrapper();
        qw.eq("business_id",documentary.getBusinessId());
        Business business = businessService.getOne(qw);
        business.setDocumentaryId(businessStatic);
        businessService.updateById(business);
        return "redirect:queryBusinessName.do?businessId="+documentary.getBusinessId();
    }

}
