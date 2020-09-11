package com.hy.crm.entity.bo;

import com.hy.crm.entity.Emp;
import lombok.Data;

import java.util.List;

@Data
public class ForumReplyBo {
    private Integer forumReplyId;//论坛回复id
    private Integer forumId;//论坛id
    private String principalPart;//回复内容
    private String finallyDate;//回复时间
    private Integer empId;//回复人id
    private Integer replyId;//回复id
    private Emp emp;//回复人
    private List<ForumReplyBo> forumReplyBos;//回复
    private Integer forumReplyStatic;//状态(1001成功,1002删除)
}
