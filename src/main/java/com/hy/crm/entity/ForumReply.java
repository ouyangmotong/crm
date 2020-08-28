package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 回复表
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ForumReply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 回复表id
     */
    @TableId(value = "forum_reply_id", type = IdType.AUTO)
    private Integer forumReplyId;

    /**
     * 论坛id
     */
    private Integer forumId;

    /**
     * 回复内容
     */
    private String principalPart;

    /**
     * 回复时间
     */
    private String finallyDate;

    /**
     * 回复人id
     */
    private Integer empId;

    /**
     * 回复id
     */
    private Integer replyId;

    /**
     * 状态(1001成功,1002删除)
     */
    private Integer forumReplyStatic;


}
