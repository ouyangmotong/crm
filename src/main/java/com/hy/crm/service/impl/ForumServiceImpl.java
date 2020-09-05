package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Emp;
import com.hy.crm.entity.Forum;
import com.hy.crm.entity.ForumReply;
import com.hy.crm.entity.bo.ForumBo;
import com.hy.crm.mapper.ForumMapper;
import com.hy.crm.service.IBusinessService;
import com.hy.crm.service.IEmpService;
import com.hy.crm.service.IForumReplyService;
import com.hy.crm.service.IForumService;
import com.hy.crm.util.LayUIData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 论坛表 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
@Transactional
public class ForumServiceImpl extends ServiceImpl<ForumMapper, Forum> implements IForumService {
    @Autowired
    private IEmpService empService;
    @Autowired
    private IBusinessService businessService;
    @Autowired
    private IForumReplyService forumReplyService;

    /**
     * 按条件分页查询所有帖子
     * @param page 当前页
     * @param limit 每页显示条数
     * @param dept 条件编号
     * @param name 条件内容
     * @return
     */
    public LayUIData queryForum(Integer page, Integer limit, Integer dept, String name){
        LayUIData layUIData = new LayUIData();
        QueryWrapper queryWrapper = new QueryWrapper<>();
        if(dept != null && dept != 0){
            if(dept == 1001){//按主题
                queryWrapper.eq("headline",name);
            }else if (dept == 1002){//按用户
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
            }else if (dept == 1003){//按点击
                int forumClicks = -1;
                try {
                    if(Integer.parseInt(name) >= 0){
                        forumClicks = Integer.parseInt(name);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                if(forumClicks >= 0){//如果输入的点击数不是非法的就查询
                    queryWrapper.eq("forum_clicks",forumClicks);
                }
            }
        }
        queryWrapper.eq("forum_static",1001);//帖子是可用状态
        //分页查询
        IPage iPage= page(new Page<Forum>(page, limit),queryWrapper);
        List<ForumBo> list = new ArrayList<>();//存所有主题
        for (Forum f:(List<Forum>)iPage.getRecords()){
            ForumBo forumBo = new ForumBo();
            BeanUtils.copyProperties(f , forumBo);

            if(f.getForumClassifyId() != null){
                if(f.getForumClassifyId() == 1001){//分类名称
                    forumBo.setForumClassify("商机讨论板");
                }else if(f.getForumClassifyId() == 1002){
                    forumBo.setForumClassify("合理化建议");
                }
                else if(f.getForumClassifyId() == 1003){//分类名称
                    forumBo.setForumClassify("技术交流");
                }
                else if(f.getForumClassifyId() == 1004){//分类名称
                    forumBo.setForumClassify("企业文化");
                }
                else if(f.getForumClassifyId() == 1005){//分类名称
                    forumBo.setForumClassify("生活娱乐");
                }
            }

            queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("emp_id",f.getEmpId());
            forumBo.setEmp(empService.getOne(queryWrapper));//查询用户

            if(f.getBusinessId() != null){
                queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("business_id",f.getBusinessId());
                Business business = businessService.getOne(queryWrapper);//查询所属商机
                forumBo.setBusiness(business);
                forumBo.setBusinessName(business.getBusinessName());
            }else {
                forumBo.setBusinessName("");
            }

            queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("forum_id",f.getForumId());
            List<ForumReply> frlist = forumReplyService.list(queryWrapper);//根据主贴id查询回复
            forumBo.setForumReplyBoNum(frlist.size());//回复数

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String finalReplyDate = f.getForumDate();//最终回复时间，默认是发帖时间
            for(ForumReply fr : frlist){
                try {
                    if(sdf.parse(finalReplyDate).getTime()<sdf.parse(fr.getFinallyDate()).getTime()){//当前最新回复时间小于list集合内的回复时间
                        finalReplyDate = fr.getFinallyDate();//赋值成为新的最后回复时间
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            forumBo.setFinalReplyDate(finalReplyDate);//最后回复时间

            list.add(forumBo);
        }
        layUIData.setCode(0);
        layUIData.setMsg("查询成功");
        layUIData.setCount((int)iPage.getTotal());
        layUIData.setData(list);
        return layUIData;
    }

}
