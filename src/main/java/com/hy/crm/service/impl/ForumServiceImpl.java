package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Emp;
import com.hy.crm.entity.Forum;
import com.hy.crm.mapper.ForumMapper;
import com.hy.crm.service.IEmpService;
import com.hy.crm.service.IForumService;
import com.hy.crm.util.LayUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        QueryWrapper<Forum> queryWrapper = new QueryWrapper<>();
        if(dept != null && dept != 0){
            if(dept == 1001){//按主题
                queryWrapper.eq("headline",name);
            }else if (dept == 1002){//按用户
                QueryWrapper<Emp> empQueryWrapper = new QueryWrapper<>();
                empQueryWrapper.eq("emp_name",name);
                List<Emp> elist = empService.list(empQueryWrapper);
                if(elist.size() > 0){//能查出作者就可以按作者查询
                    int[] empIds= new int[elist.size()];
                    for(int i=0;elist.size()>i;i++){
                        empIds[i] = elist.get(i).getEmpId();
                    }
                    queryWrapper.in("empId",empIds);
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
        layUIData.setCode(0);
        layUIData.setMsg("查询成功");
        layUIData.setCount((int)iPage.getTotal());
        layUIData.setData(iPage.getRecords());
        return layUIData;
    }

}
