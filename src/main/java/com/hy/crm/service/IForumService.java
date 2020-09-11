package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.Emp;
import com.hy.crm.entity.Forum;
import com.hy.crm.util.LayUIData;

/**
 * <p>
 * 论坛表 服务类
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
public interface IForumService extends IService<Forum> {
    LayUIData queryForum(Integer page, Integer limit, Integer dept, String name);//按条件分页查询所有帖子
    void saveForum(Forum forum, Emp emp);
}
