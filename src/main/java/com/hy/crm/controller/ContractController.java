package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
    public List<Contract> queryAllByStatic(){
        UpdateWrapper<Contract> updateWrapper = new UpdateWrapper();
        updateWrapper.eq("contractStatic","1001");
        List<Contract> list=contractService.list(updateWrapper);
        return list;
    }

    /**
     * 根据合同id查询合同编号
     * @param id 合同id
     */
    @RequestMapping("/queryContractNo.do")
    public String queryContractNo(int id){
        QueryWrapper<Contract> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("contractId",id);
        Contract contract = contractService.getOne(queryWrapper);
        //获得合同编号
        return contract.getContractNo();
    }
}
