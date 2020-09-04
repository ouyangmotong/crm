package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Documentary;
import com.hy.crm.entity.Emp;
import com.hy.crm.mapper.DocumentaryMapper;
import com.hy.crm.service.IDocumentaryService;
import com.hy.crm.service.IEmpService;
import com.hy.crm.util.LayUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 跟单 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
@Transactional
public class DocumentaryServiceImpl extends ServiceImpl<DocumentaryMapper, Documentary> implements IDocumentaryService {
    @Autowired
    private IEmpService empService;

    /**
     * 根据条件分页查询跟单
     * @param page
     * @param limit
     * @param dept
     * @param name
     * @return
     */
    public LayUIData queryDocumentary(Integer page, Integer limit, Integer dept, String name){
        LayUIData layUIData = new LayUIData();
        QueryWrapper queryWrapper = new QueryWrapper<>();
        if(dept != null && dept != 0){
            if(dept == 1001){//跟单时间
                queryWrapper.eq("documentary_date",name);
            }else if (dept == 1002){//跟单主题
                queryWrapper.eq("business_name",name);
            }else if (dept == 1003){//跟单人
                queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("emp_name",name);
                List<Emp> elist = empService.list(queryWrapper);
                if(elist.size() > 0){//能查出作者就可以按作者查询
                    List empIds = new ArrayList<>();
                    for(Emp e : elist){
                        empIds.add(e.getEmpId());
                    }
                    queryWrapper = new QueryWrapper<>();
                    queryWrapper.in("emp_id",empIds);
                }
            }
        }
        //分页查询
        IPage iPage= page(new Page<Documentary>(page, limit),queryWrapper);
        List<Documentary> list = iPage.getRecords();
        layUIData.setCode(0);
        layUIData.setMsg("查询成功");
        layUIData.setCount((int)iPage.getTotal());
        layUIData.setData(iPage.getRecords());
        return layUIData;
    }

}
