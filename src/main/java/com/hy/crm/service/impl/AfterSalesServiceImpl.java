package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.AfterSales;
import com.hy.crm.entity.Contract;
import com.hy.crm.mapper.AfterSalesMapper;
import com.hy.crm.service.IAfterSalesService;
import com.hy.crm.service.IContractService;
import com.hy.crm.util.LayUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 售后服务表 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
@Transactional
public class AfterSalesServiceImpl extends ServiceImpl<AfterSalesMapper, AfterSales> implements IAfterSalesService {

    /**
     * 注入售后的service
     */
    @Autowired
    private IAfterSalesService iAfterSalesService;

    /**
     * 注入合同service
     */
    @Autowired
    private IContractService iContractService;

    @Override
    public LayUIData queryAll(int page, int limit, int kind, String content){
        LayUIData layUIData = new LayUIData();
        IPage iPage = new Page<AfterSales>(page, limit);
        QueryWrapper<AfterSales> queryWrapper=new QueryWrapper<>();
        if(!StringUtils.isEmpty(content) && !StringUtils.isEmpty(kind)){
            if(kind == 1){
                queryWrapper.like("headline",content);
            }else if(kind == 2){
                queryWrapper.like("service_classify",content);
            }else if(kind == 3){
                queryWrapper.like("begin_date",content);
            }else if(kind == 4){
                queryWrapper.like("service_staff",content);
            }else if(kind == 5){
                queryWrapper.like("service_score",content);
            }
        }
        IPage iPage1 = iAfterSalesService.page(iPage, queryWrapper);
        layUIData.setData(iPage1.getRecords());
        layUIData.setCode(0);
        layUIData.setCount((int) iPage1.getTotal());
        layUIData.setMsg("查询成功");
        return layUIData;
    }

    @Override
    public Boolean addAfterSales(AfterSales afterSales,String img,String contractNo){
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        String date=df.format(new Date());
        //根据合同编号查询合同的id
        QueryWrapper<Contract> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("contract_no",contractNo);
        Contract contract=iContractService.getOne(queryWrapper);
        //把得到的id赋值进去
        afterSales.setFile(img);
        //把查询出来的id赋值进去
        afterSales.setContractId(contract.getContractId());
        //添加最后修改时间
        afterSales.setLastTime(date);
        Boolean b=iAfterSalesService.save(afterSales);
        return b;
    }
}
