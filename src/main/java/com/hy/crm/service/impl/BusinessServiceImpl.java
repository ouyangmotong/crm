package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.*;
import com.hy.crm.mapper.*;
import com.hy.crm.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商机表 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
@Transactional
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private BusinessStaticMapper businessStaticMapper;
    @Autowired
    private ForumMapper forumMapper;

    @Autowired
    private DocumentaryMapper documentaryMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public IPage<AssistBusy> findById(Integer page,Integer limit,Integer id) {
        List<AssistBusy> list=new ArrayList<>();

            QueryWrapper queryWrapper=new QueryWrapper();
            queryWrapper.eq("clientele_id",id);
            IPage<Business> p=new Page(page,limit);
            IPage<Business> crods= businessMapper.selectPage(p,queryWrapper);
            List<Business> records = crods.getRecords();
            IPage<AssistBusy> iPage=new Page();
            for(Business data:records){
                AssistBusy aStatic = findStatic(data);
                list.add(aStatic);
            }
            iPage.setRecords(list);
            iPage.setTotal(crods.getTotal());

            return iPage;
    }

    //查询所有的商机信息
    @Override
    public List<AssistBusy> findAll(IPage<AssistBusy> page,AssistBusy assistBusy) {
        List<AssistBusy> list=new ArrayList<>();
        List<AssistBusy> allBusy = businessMapper.findAllBusy(page,assistBusy);

        for(AssistBusy data:allBusy){
            List<Forum> forumass = findForumass(data.getBusinessId());
            data.setNum(forumass.size());
            list.add(data);
            }
            return list;
    }

    /**
     * 根据id查询商机
     * @param id
     */
    @Override
    public BusyBean findByIdBusy(Integer id){
       return businessMapper.findByIdBusy(id);
    }

    @Override
    public int updateBusiness(Business business) {
        return businessMapper.updateBusiness(business);
    }

    @Override
    public int updateClient(Clientele clientele) {
        return businessMapper.updateClient(clientele);
    }

    @Override
    public int updateEmp(Emp emp) {
        return businessMapper.updateEmp(emp);
    }

    /***
     * 查询帖子数
     * @param id
     * @return
     */

    private List<Forum> findForumass(int id){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("business_id",id);
        List<Forum> list = forumMapper.selectList(queryWrapper);
        return list;

    }


    private AssistBusy  findStatic(Business arg){
        AssistBusy assistBusy=new AssistBusy();
        assistBusy.setBusinessId(arg.getBusinessId());
        assistBusy.setBusinessName(arg.getBusinessName());
        assistBusy.setEstimatedAmount(arg.getEstimatedAmount());
        //查询所有的商机阶段
        QueryWrapper  queryWrapper=new QueryWrapper();
        queryWrapper.eq("id",arg.getBusinessstaticId());
        List<BusinessStatic> list = businessStaticMapper.selectList(queryWrapper);
        for(BusinessStatic data:list){
            assistBusy.setName(data.getName());
        }
        //查询所有的跟单的日期
        List<Documentary> documentary = findDocumentary(arg.getBusinessId());
        for(Documentary data:documentary){
            assistBusy.setDocumentarydate(data.getDocumentaryDate());
        }
       //拿到负责人
        List<Emp> emp = findEmp(arg.getEmpId());
        for(Emp data:emp){
            assistBusy.setEmpname(data.getEmpName());
        }

        //查询所有的帖子数
        List<Forum> forum = findForum(arg.getBusinessId());
            assistBusy.setNum(forum.size());
          return assistBusy;
    }

    /***
     * 查询负责人
     * @param id
     * @return
     */
    private List<Emp> findEmp(int id){
        List<Emp> list = empMapper.findById(id);
        return list;

    }

    /***
     * 查询跟单
     */
    private List<Documentary> findDocumentary(int id){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("business_id",id);
        List<Documentary> list = documentaryMapper.selectList(queryWrapper);
        return list;

    }

    /***
     * 查询帖子数
     * @param id
     * @return
     */

    private List<Forum> findForum(int id){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("business_id",id);
        List<Forum> list = forumMapper.selectList(queryWrapper);
        return list;

    }



}
