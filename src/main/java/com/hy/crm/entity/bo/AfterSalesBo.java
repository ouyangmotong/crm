package com.hy.crm.entity.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Jackson
 * @date 2020/9/10 10:41
 * @Description:
 */
@Data
public class AfterSalesBo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 售后服务id
     */
    private Integer afterSalesid;

    /**
     * 主题
     */
    private String headline;

    /**
     * 状态(1001已登记待处理,1002处理中,1003结束)
     */
    private Integer aftStatic;

    /**
     * 责任人
     */
    private String dutyPerson;

    /**
     * 参与人
     */
    private String participant;

    /**
     * 客户名字
     */
    private String clienteleName;

    /**
     * 合同编号
     */
    private String contractId;

    /**
     * 合同主要内容
     */
    private String contractContent;

    /**
     * 对方联系人
     */
    private String contacts;

    /**
     * 固定电话
     */
    private String telephone;

    /**
     * 移动电话
     */
    private String phone;

    /**
     * 邮件/QQ
     */
    private String email;

    /**
     * 服务类型(1001故障申报、1002业务咨询、1003实施或培训、1004主动关怀、1005其他)
     */
    private Integer serviceClassify;

    /**
     * 服务方式
     */
    private Integer classifyType;

    /**
     * 开始时间
     */
    private String beginDate;

    /**
     * 结束时间
     */
    private String endDate;

    /**
     * 服务内容
     */
    private String serviceContent;

    /**
     * 客户反馈
     */
    private String customerFeedback;

    /**
     * 服务人员
     */
    private String serviceStaff;

    /**
     * 服务评分
     */
    private Integer serviceScore;

    /**
     * 附件
     */
    private String file;
}
