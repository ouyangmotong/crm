package com.hy.crm.controller;

import com.hy.crm.entity.*;
import com.hy.crm.service.IApplyInvoiceService;
import com.hy.crm.service.IClienteleService;
import com.hy.crm.service.IContractService;
import com.hy.crm.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 开票申请表 前端控制器
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Controller
@RequestMapping("/crm/apply-invoice")
public class ApplyInvoiceController {
    @Autowired
    private IDeptService deptService;
    @Autowired
    private IContractService contractService;
    @Autowired
    private IClienteleService clienteleService;
    @Autowired
    private IApplyInvoiceService applyInvoiceService;

    @RequestMapping("/queryContractApplyInvoice.do")
    public String queryContractApplyInvoice(Model model, HttpSession session, Integer contractId){
        Emp emp = new Emp();
        //emp = (Emp) session.getAttribute("emp");//当前用户
        emp.setEmpId(1001);//写死
        emp.setEmpName("admin");
        emp.setDeptId(1001);

        Dept dept = new Dept();
        //dept = deptService.getById(emp.getDeptId());//当前部门
        dept.setDeptId(1001);//写死
        dept.setDeptName("财务部");

        Contract contract = contractService.getById(contractId);
        Clientele clientele = clienteleService.getById(contract.getClienteleId());

        model.addAttribute("emp", emp);//当前用户
        model.addAttribute("dept", dept);//当前用户
        model.addAttribute("contract", contract);//合同信息
        model.addAttribute("clientele", clientele);//客户信息
        return "wry/saveApplyInvoice.html";
    }

    /**
     * 添加
     * @param applyInvoice
     * @param accountBank 开户行名称
     * @param bankAccount 开户账号
     * @param bankAddress 开户行地址
     * @param companyTelephone 开户行电话
     * @return
     */
    @RequestMapping("/saveApplyInvoice.do")
    public String saveApplyInvoice(ApplyInvoice applyInvoice,String accountBank,String bankAccount,String bankAddress,String companyTelephone) {
        Emp emp = new Emp();
        //emp = (Emp) session.getAttribute("emp");//当前用户
        emp.setEmpId(1001);//写死
        emp.setDeptId(1001);
        emp.setEmpName("admin");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        applyInvoice.setApplyDate(sdf.format(new Date()));//申请日期

        applyInvoice.setCardNumber(accountBank+""+bankAccount);//开户行银行卡账号
        applyInvoice.setAddress(bankAddress+""+companyTelephone);//地址电话

        applyInvoice.setInvoiceStatic(1001);//1001为待审核状态

        applyInvoiceService.save(applyInvoice);

        //earningaService.save(earninga);
        return "redirect:../../wry/queryContract.html";
    }

}
