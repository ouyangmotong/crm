package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 论坛表
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Forum implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "forum_id", type = IdType.AUTO)
    private Integer forumId;

    /**
     * 分类id(1001商机讨论板,1002合理化建议,1003技术交流,1004企业文化,1005生活娱乐)
     */
    private Integer forumClassifyId;

    /**
     * 主题
     */
    private String headline;

    /**
     * 内容
     */
    private String principalPart;

    /**
     * 发布人id
     */
    private Integer empId;

    /**
     * 所属商机id
     */
    private Integer businessId;

    /**
     * 点击量
     */
    private Integer forumClicks;

    /**
     * 状态(1001成功,1002删除)
     */
    private Integer forumStatic;


}
