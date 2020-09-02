package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.Contract;
import com.hy.crm.service.IContractService;
import com.hy.crm.util.LayUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 合同表 前端控制器
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@RestController
@RequestMapping("/crm/contract")
public class ContractController {

    /**
     * 注入合同servlet
     */
    @Autowired
    private IContractService contractService;

    /**
     * 根据状态查询合同
     * 只查询合同签约成功的
     * 状态为1001的
     */
    @GetMapping("/queryAllByStatic.do")
    public LayUIData queryAllByStatic(int page,int limit){
        System.out.println("page="+page+"------------limit="+limit);
        LayUIData layUIData = new LayUIData();
        IPage iPage = new Page<Contract>(page, limit);
        UpdateWrapper<Contract> updateWrapper = new UpdateWrapper();
        IPage iPage1 = contractService.page(iPage, updateWrapper);
        layUIData.setData(iPage1.getRecords());
        layUIData.setCode(0);
        layUIData.setCount((int) iPage1.getTotal());
        layUIData.setMsg("查询成功");
        return layUIData;
    }
}
