package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Documentary;
import com.hy.crm.entity.Emp;
import com.hy.crm.entity.bo.DocumentaryBo;
import com.hy.crm.mapper.DocumentaryMapper;
import com.hy.crm.service.IBusinessService;
import com.hy.crm.service.IDocumentaryService;
import com.hy.crm.service.IEmpService;
import com.hy.crm.util.LayUIData;
import org.springframework.beans.BeanUtils;
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
    @Autowired
    private IBusinessService businessService;

    /**
     * 根据条件分页查询所有|我的跟单
     * @param page 当前页
     * @param limit 每页显示多少条
     * @param type 条件查询条件
     * @param typeValue 条件查询对应的值
     * @param belong 属于 1001查询全部 1002查询我的跟单
     * @param emp 当前用户
     * @return
     */
    public LayUIData queryDocumentary(Integer page, Integer limit, Integer type, String typeValue,Integer belong,Emp emp){
        LayUIData layUIData = new LayUIData();
        QueryWrapper queryWrapper = new QueryWrapper<>();
        if(type != null && type != 0){
            if(type == 1001){//跟单时间
                queryWrapper.eq("documentary_date",typeValue);
            }else if (type == 1002){//跟单主题
                queryWrapper.eq("business_name",typeValue);
            }else if (type == 1003){//跟单人
                queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("emp_name",typeValue);
                List<Emp> elist = empService.list(queryWrapper);
                if(elist.size() > 0){//能查出作者就可以按作者查询
                    List empIds = new ArrayList<>();
                    for(Emp e : elist){//作者可能同名
                        empIds.add(e.getEmpId());
                    }
                    queryWrapper = new QueryWrapper<>();
                    queryWrapper.in("emp_id",empIds);
                }
            }
        }

        if (belong == 1002){//按当前用户查询
            queryWrapper.eq("emp_id",emp.getEmpId());//当前用户
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

    /**
     * 根据商机id查询跟单信息
     * @param businessId 商机id
     * @return
     */
    public List<DocumentaryBo> queryBusinessById(String businessId){
        List<DocumentaryBo> dblist = new ArrayList<>();//储存所有跟单信息

        //根据商机id查询该商机下所有跟单
        QueryWrapper qw = new QueryWrapper();
        qw.eq("business_id",businessId);
        List<Documentary> dlist = list(qw);

        for (Documentary d : dlist){//跟单类型
            DocumentaryBo db = new DocumentaryBo();
            BeanUtils.copyProperties(d , db);
            if(d.getDocumentaryType() == 1001){//电话沟通
                db.setDocumentaryTypeName("电话沟通");
            }else if(d.getDocumentaryType() == 1002){//邮件联系
                db.setDocumentaryTypeName("邮件联系");
            }else if(d.getDocumentaryType() == 1003){//网上交流
                db.setDocumentaryTypeName("网上交流");
            }else if(d.getDocumentaryType() == 1004){//上面拜访
                db.setDocumentaryTypeName("上面拜访");
            }else if(d.getDocumentaryType() == 1005){//产品送样
                db.setDocumentaryTypeName("产品送样");
            }else if(d.getDocumentaryType() == 1006){//客户招待
                db.setDocumentaryTypeName("客户招待");
            }else if(d.getDocumentaryType() == 1007){//其他
                db.setDocumentaryTypeName("其他");
            }
            dblist.add(db);
        }
        return dblist;
    }

    /**
     * 继续跟单
     * @param documentary 跟单信息
     * @param businessStatic 跟单商机表跟单状态
     */
    public void saveDocumentary(Documentary documentary,Integer businessStatic){
        save(documentary);//插入跟单信息

        //修改商机表中的跟单状态
        QueryWrapper qw = new QueryWrapper();
        qw.eq("business_id",documentary.getBusinessId());
        Business business = businessService.getOne(qw);
        business.setDocumentaryId(businessStatic);
        businessService.updateById(business);
    }

    /**
     * 新增跟单
     * @param documentary 跟单信息
     * @param businessId 商机id
     * @param businessStatic 商机状态
     * @param emp 当前用户
     */
    public void saveNewDocumentary(Documentary documentary,Integer businessId,Integer businessStatic,Emp emp){
        QueryWrapper qw = new QueryWrapper();

        //修改商机表中的跟单状态
        Business business = businessService.getById(businessId);
        business.setDocumentaryId(businessStatic);
        businessService.updateById(business);

        documentary.setBusinessId(business.getBusinessId());
        documentary.setBusinessName(business.getBusinessName());

        documentary.setEmpId(emp.getEmpId());
        documentary.setEmpName(emp.getEmpName());

        save(documentary);//插入跟单信息
    }

}
