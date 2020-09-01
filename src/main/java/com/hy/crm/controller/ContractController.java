package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Contract;
import com.hy.crm.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public void queryAllByStatic(){
        QueryWrapper<Contract> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("contract_static","1001");
        List list=contractService.list(queryWrapper);
        System.out.println(list);
    }
}
