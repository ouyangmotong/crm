package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Emp;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    /*public ForumBo queryByIdForumReply(Integer forumId){
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("forum_id",forumId);//根据帖子id查询帖子
        Forum forum = forumService.getOne(qw);

        //每查询一次帖子 增加一次帖子点击量
        forum.setForumClicks(forum.getForumClicks()+1);//数据库修改帖子点击量
        forumService.updateById(forum);

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
    }*/

    /**
     * 根据id查询帖子
     * @param forumId
     * @return
     */
    @Override
    public ForumBo queryByIdForumReply2(Integer forumId){
        QueryWrapper qw = new QueryWrapper<>();

        qw.eq("forum_id",forumId);//根据帖子id查询帖子
        Forum forum = forumService.getOne(qw);

        //每查询一次帖子 增加一次帖子点击量
        forum.setForumClicks(forum.getForumClicks()+1);//数据库修改帖子点击量
        forumService.updateById(forum);

        ForumBo forumBo = new ForumBo();
        BeanUtils.copyProperties(forum , forumBo);//把forum对象的值赋给forumBo对象
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

        //查询发帖人
        qw = new QueryWrapper();
        qw.eq("emp_id",forum.getEmpId());
        forumBo.setEmp(empService.getOne(qw));

        return forumBo;
    }

    /**
     * 查询所有回复
     * @param frlist
     * @return
     */
    @Override
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

    /**
     * 添加评论/回复
     * @param forumId 帖子id
     * @param replyId 回复回复id
     * @param principalPart 回复内容
     * @param emp 当前用户
     */
    @Override
    public void saveForumReply(Integer forumId, Integer replyId, String principalPart, Emp emp){
        ForumReply fr = new ForumReply();

        if(principalPart != null && !principalPart.equals("")){//必须有回复内容才能回复
            fr.setForumId(forumId);//主贴id
            fr.setPrincipalPart(principalPart);//回复内容
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            fr.setFinallyDate(dateFormat.format(new Date()));//回复时间
            fr.setEmpId(emp.getEmpId());//回复用户
            fr.setReplyId(replyId);//replyId(回复评论id) 如果是-1就是评论 如果是有id就是回复评论
            fr.setForumReplyStatic(1001);//回复状态成功

            save(fr);
        }

    }

}
