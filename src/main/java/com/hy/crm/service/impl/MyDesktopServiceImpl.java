package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.bo.MyDesktopBo;
import com.hy.crm.mapper.MyDesktopMapper;
import com.hy.crm.service.IContractService;
import com.hy.crm.service.IMyDesktopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jackson
 * @date 2020/9/11 18:09
 * @Description:
 */
@Service
@Transactional
public class MyDesktopServiceImpl extends ServiceImpl<MyDesktopMapper, MyDesktopBo> implements IMyDesktopService {

    private IContractService iContractService;
    /**
     * 查询我的桌面所需的数据
     */
    public void queryNum(){
        //查询全部客户

        //查询全部商机
        //查询全部合同
        //查询不同状态下不同商机的的金额
    }
}
