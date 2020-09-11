package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Documentary;
import com.hy.crm.entity.Emp;
import com.hy.crm.entity.bo.DocumentaryBo;
import com.hy.crm.service.IBusinessService;
import com.hy.crm.service.IDocumentaryService;
import com.hy.crm.service.IEmpService;
import com.hy.crm.util.LayUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
    @Autowired
    private IEmpService empService;

    /**
     * 根据条件分页查询所有跟单
     * @param page 当前页
     * @param limit 每页显示多少条
     * @param type 条件查询类型 1001跟单时间 1002跟单主题 1003跟单人
     * @param typeValue 条件查询值
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryDocumentary.do")
    public LayUIData queryDocumentary(Integer page, Integer limit, Integer type, String typeValue, HttpSession session){
        Emp emp = new Emp();
        //emp = (Emp) session.getAttribute("emp");//当前用户
        emp.setEmpId(1001);//写死
        return documentaryService.queryDocumentary(page,limit,type,typeValue,1001,emp);//1001查询全部 1002查询我的
    }

    /**
     * 根据条件分页查询我的跟单
     * @param page
     * @param limit
     * @param type
     * @param typeValue
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryMyDocumentary.do")
    public LayUIData queryMyDocumentary(Integer page, Integer limit, Integer type, String typeValue,HttpSession session){
        Emp emp = new Emp();
        //emp = (Emp) session.getAttribute("emp");//当前用户
        emp.setEmpId(1001);//写死
        return documentaryService.queryDocumentary(page,limit,type,typeValue,1002,emp);//1001查询全部 1002查询我的
    }

    /**
     * 根据商机id查询跟单信息
     * @param businessId 主题id
     * @return
     */
    @RequestMapping("/queryBusinessById.do")
    public String queryBusinessById(String businessId, Model model){
        List<DocumentaryBo> dblist = documentaryService.queryBusinessById(businessId);

        model.addAttribute("dblist",dblist);//跟单信息
        model.addAttribute("documentaryBo",dblist.get(0));//第一条跟单信息
        model.addAttribute("documentaryStatic",businessService.getById(businessId).getDocumentaryId());//商机跟单状态
        return "wry/queryByDocumentary.html";
    }

    /**
     * 继续跟单
     * @param documentary 跟单信息
     * @param businessStatic 商机跟单状态
     * @return
     */
    @RequestMapping("/saveDocumentary.do")
    public String saveDocumentary(Documentary documentary,Integer businessStatic){
        documentaryService.saveDocumentary(documentary,businessStatic);
        return "redirect:queryBusinessById.do?businessId="+documentary.getBusinessId();
    }

    /**
     * 新增跟单前查询可新增的商机
     * @param model
     * @return
     */
    @RequestMapping("/queryBusinessDocumentary.do")
    public String queryBusinessDocumentary(Model model,HttpSession session){
        QueryWrapper qw = new QueryWrapper();
        qw.eq("documentary_id",1001);//1001为待跟单状态
        List<Business> blist = businessService.list(qw);//查询跟单状态为待跟单的所有商机
        Emp emp = new Emp();
        //emp = (Emp) session.getAttribute("emp");//当前用户
        emp.setEmpId(1001);//写死
        emp.setEmpName("admin");
        model.addAttribute("blist",blist);//商机信息
        model.addAttribute("emp", emp);//当前用户
        return "wry/saveDocumentary.html";
    }

    /**
     * 新增跟单
     * @param documentary 跟单信息
     * @param businessId 商机id
     * @param businessStatic 商机状态
     * @return
     */
    @RequestMapping("/saveNewDocumentary.do")
    public String saveNewDocumentary(Documentary documentary,Integer businessId,Integer businessStatic,HttpSession session) {
        Emp emp = new Emp();
        //emp = (Emp) session.getAttribute("emp");//当前用户
        emp.setEmpId(1001);//写死
        emp.setEmpName("admin");
        documentaryService.saveNewDocumentary(documentary,businessId,businessStatic,emp);
        return "redirect:queryBusinessById.do?businessId="+documentary.getBusinessId();
    }

}
