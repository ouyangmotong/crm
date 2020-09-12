package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.bo.MyDesktopBo;
import com.hy.crm.mapper.MyDesktopMapper;
import com.hy.crm.service.IBusinessService;
import com.hy.crm.service.IClienteleService;
import com.hy.crm.service.IContractService;
import com.hy.crm.service.IMyDesktopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Jackson
 * @date 2020/9/11 18:09
 * @Description:
 */
@Service
@Transactional
public class MyDesktopServiceImpl extends ServiceImpl<MyDesktopMapper, MyDesktopBo> implements IMyDesktopService {

    /**
     * 客户service
     */

    @Autowired
    private IClienteleService iClienteleService;
    /**
     * 商机service
     */

    @Autowired
    private IBusinessService iBusinessService;

    /**
     * 合同service
     */
    private IContractService iContractService;
    /**
     * 查询我的桌面所需的数据
     */
    @Override
    public void queryNum(){
        MyDesktopBo myDesktopBo=new MyDesktopBo();
        //查询全部客户
        int a=iClienteleService.count(null);
        myDesktopBo.setClienteleNum(a);
        //查询全部商机
        int b=iBusinessService.count(null);
        myDesktopBo.setBusinessNum(b);
        //查询全部合同
        int c=iContractService.count(null);
        myDesktopBo.setContractNum(c);
        /**查询不同状态下不同商机的的金额
         * 1001初期沟通,
         * 1002方案与报价,
         * 1003竞争或投标,
         * 1004商务谈判,
         * 1005成交,
         * 1006丢单,
         * 1007搁置
         **/
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("businessStatic_id","1006");
        List<Business> list = iBusinessService.list(queryWrapper);
        //预计成交金额
        int EstimatedAmount=0;
        BigDecimal bigDecimal=new BigDecimal("100");
        for (Business business:list) {
            EstimatedAmount += business.getEstimatedAmount();
        }
        BigDecimal bigDecimal1=new BigDecimal(EstimatedAmount);
        BigDecimal bigDecimal2= bigDecimal1.divide(bigDecimal);

        //myDesktopBo.setThrowSum(bigDecimal2);
    }

    public Float IntZhuanFloat(int a) {
        BigDecimal bigDecimal=new BigDecimal("100");
        BigDecimal bigDecimal1=new BigDecimal(a);
        BigDecimal bigDecimal2= bigDecimal1.divide(bigDecimal);
        return Float.parseFloat(String.valueOf(bigDecimal2));
    }
}