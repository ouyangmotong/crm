package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 售后服务表
 * </p>
 *
 * @author Jackson
 * @since 2020-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AfterSales implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 售后服务id
     */
    @TableId(value = "after_salesId", type = IdType.AUTO)
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
     * 客户id
     */
    private Integer clienteleId;

    /**
     * 合同id
     */
    private Integer contractId;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginDate;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

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

    /**
     * 最后修改时间
     */
    private String lastTime;


}
