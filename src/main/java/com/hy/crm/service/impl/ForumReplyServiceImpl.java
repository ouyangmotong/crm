package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Forum;
import com.hy.crm.entity.ForumReply;
import com.hy.crm.entity.bo.ForumBo;
import com.hy.crm.entity.bo.ForumReplyBo;
import com.hy.crm.mapper.ForumReplyMapper;
import com.hy.crm.service.IEmpService;
import com.hy.crm.service.IForumReplyService;
import com.hy.crm.service.IForumService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 回复表 服务实现类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Service
@Transactional
public class ForumReplyServiceImpl extends ServiceImpl<ForumReplyMapper, ForumReply> implements IForumReplyService {
    @Autowired
    private IForumService forumService;
    @Autowired
    private IEmpService empService;

    /**
     * 根据帖子id查询帖子及所有回复
     * @param forumId
     * @return
     */
    public ForumBo queryByIdForumReply(Integer forumId){
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("forum_id",forumId);//根据帖子id查询帖子
        Forum forum = forumService.getOne(qw);
        ForumBo forumBo = new ForumBo();
        BeanUtils.copyProperties(forum , forumBo);
        if(forum.getForumClassifyId() == 1001){//分类名称
            forumBo.setForumClassify("商机讨论板");
        }else if(forum.getForumClassifyId() == 1002){
            forumBo.setForumClassify("合理化建议");
        }
        else if(forum.getForumClassifyId() == 1003){//分类名称
            forumBo.setForumClassify("技术交流");
        }
        else if(forum.getForumClassifyId() == 1004){//分类名称
            forumBo.setForumClassify("企业文化");
        }
        else if(forum.getForumClassifyId() == 1005){//分类名称
            forumBo.setForumClassify("生活娱乐");
        }
        qw = new QueryWrapper();
        qw.eq("emp_id",forum.getEmpId());
        forumBo.setEmp(empService.getOne(qw));//发帖人
        qw = new QueryWrapper();
        qw.eq("forum_id",forumId);
        qw.eq("forum_reply_static",1001);//回复是可用状态
        List<ForumReply> list = list(qw);//根据主贴id查询对应回复
        forumBo.setForumReplyBos(queryForumReplyBos(list));//回复
        return forumBo;
    }

    /**
     * 根据id查询帖子
     * @param forumId
     * @return
     */
    public ForumBo queryByIdForumReply2(Integer forumId){
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("forum_id",forumId);//根据帖子id查询帖子
        Forum forum = forumService.getOne(qw);
        ForumBo forumBo = new ForumBo();
        BeanUtils.copyProperties(forum , forumBo);
        if(forum.getForumClassifyId() == 1001){//分类名称
            forumBo.setForumClassify("商机讨论板");
        }else if(forum.getForumClassifyId() == 1002){
            forumBo.setForumClassify("合理化建议");
        }
        else if(forum.getForumClassifyId() == 1003){//分类名称
            forumBo.setForumClassify("技术交流");
        }
        else if(forum.getForumClassifyId() == 1004){//分类名称
            forumBo.setForumClassify("企业文化");
        }
        else if(forum.getForumClassifyId() == 1005){//分类名称
            forumBo.setForumClassify("生活娱乐");
        }
        qw = new QueryWrapper();
        qw.eq("emp_id",forum.getEmpId());
        forumBo.setEmp(empService.getOne(qw));//发帖人
        qw = new QueryWrapper();
        qw.eq("forum_id",forumId);
        qw.eq("forum_reply_static",1001);//回复是可用状态
        return forumBo;
    }

    /**
     * 查询所有回复
     * @param frlist
     * @return
     */
    public List<ForumReplyBo> queryForumReplyBos(List<ForumReply> frlist){
        List<ForumReplyBo> list=new ArrayList<>();
        QueryWrapper qw = new QueryWrapper<>();
        for (ForumReply fr : frlist){
            if(fr.getReplyId() == -1){//查询一级回复
                ForumReplyBo forumReplyBo = new ForumReplyBo();
                BeanUtils.copyProperties(fr , forumReplyBo);
                qw = new QueryWrapper();
                qw.eq("emp_id",fr.getEmpId());
                forumReplyBo.setEmp(empService.getOne(qw));//回复人
                forumReplyBo.setForumReplyBos(queryForumReplyBos2(frlist,fr.getForumReplyId()));//回复
                list.add(forumReplyBo);
            }
        }
        return list;
    }
    public List<ForumReplyBo> queryForumReplyBos2(List<ForumReply> frlist,Integer forumReplyId){
        List<ForumReplyBo> list=new ArrayList<>();
        QueryWrapper qw = new QueryWrapper<>();
        for (ForumReply fr : frlist){
            if(fr.getReplyId() == forumReplyId || fr.getReplyId().equals(forumReplyId)){//如果有儿子
                Boolean son = false;
                ForumReplyBo forumReplyBo = new ForumReplyBo();
                BeanUtils.copyProperties(fr , forumReplyBo);
                qw = new QueryWrapper();
                qw.eq("emp_id",fr.getEmpId());
                forumReplyBo.setEmp(empService.getOne(qw));//回复人
                for (ForumReply frr : frlist){//判断是否有孙子
                    if (frr.getReplyId() == fr.getForumReplyId() || frr.getReplyId().equals(fr.getForumReplyId())){
                        son = true;
                    }
                }
                if(son){//如果有孙子就查孙子
                    forumReplyBo.setForumReplyBos(queryForumReplyBos2(frlist,fr.getForumReplyId()));
                }
                list.add(forumReplyBo);
            }
        }
        return list;
    }

}
