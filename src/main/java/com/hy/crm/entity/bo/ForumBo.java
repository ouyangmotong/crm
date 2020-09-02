package com.hy.crm.entity.bo;

import com.hy.crm.entity.Emp;
import lombok.Data;

import java.util.List;

@Data
public class ForumBo {
    private Integer forumId;//id
    private Integer forumClassifyId;//分类id(1001商机讨论板,1002合理化建议,1003技术交流,1004企业文化,1005生活娱乐)
    private String forumClassify;//分类
    private String headline;//主题
    private String principalPart;//内容
    private Integer empId;//发布人id
    private Emp emp;//发布人
    private Integer businessId;//所属商机id
    private String forumDate;//发帖时间
    private Integer forumClicks;//点击量
    private Integer forumStatic;//状态(1001成功,1002删除)
    private List<ForumReplyBo> forumReplyBos;//回复
}
