package com.hy.crm.controller;

import com.hy.crm.entity.Clientele;
import com.hy.crm.entity.Contract;
import com.hy.crm.entity.Earninga;
import com.hy.crm.entity.Emp;
import com.hy.crm.service.IClienteleService;
import com.hy.crm.service.IContractService;
import com.hy.crm.service.IEarningaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 收入表 前端控制器
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Controller
@RequestMapping("/crm/earninga")
public class EarningaController {
    @Autowired
    private IEarningaService earningaService;
    @Autowired
    private IContractService contractService;
    @Autowired
    private IClienteleService clienteleService;

    /**
     * 添加前查询
     * @param model
     * @param session
     * @param contractId
     * @return
     */
    @RequestMapping("/queryContractEarninga.do")
    public String queryContractEarninga(Model model, HttpSession session,Integer contractId){
        Emp emp = new Emp();
        //emp = (Emp) session.getAttribute("emp");//当前用户
        emp.setEmpId(1001);//写死
        emp.setEmpName("admin");

        Contract contract = contractService.getById(contractId);//查询合同
        Clientele clientele = clienteleService.getById(contract.getClienteleId());//查询客户

        Integer earningNum = earningaService.queryEarningNum(contractId);//根据合同id查询当已收入金额

        model.addAttribute("emp", emp);//当前用户
        model.addAttribute("contract", contract);//合同信息
        model.addAttribute("clientele", clientele);//客户信息
        model.addAttribute("earningNum", earningNum);//已收入金额
        return "wry/saveEarninga.html";
    }

    /**
     * 添加
     * @param earninga
     * @return
     */
    @RequestMapping("/saveEarninga.do")
    public String saveEarninga(Earninga earninga) {
        earningaService.saveEarning(earninga);
        return "redirect:../../wry/queryContract.html";
    }

}
