package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 售后服务表
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "after_sales")
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
    @TableField(value = "headline")
    private String headline;

    /**
     * 状态(1001已登记待处理,1002处理中,1003已完成)
     */
    @TableField(value = "aft_static")
    private Integer aftStatic;

    /**
     * 责任人id
     */
    @TableField(value = "duty_person")
    private Integer empId;

    /**
     * 客户id
     */
    @TableField(value = "clientele_id")
    private Integer clienteleId;

    /**
     * 合同id
     */
    @TableField(value = "contract_id")
    private Integer contractId;

    /**
     * 对方联系人
     */
    @TableField(value = "contacts")
    private String contacts;

    /**
     * 固定电话
     */
    @TableField(value = "telephone")
    private String telephone;

    /**
     * 移动电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 邮件/QQ
     */
    @TableField(value = "email")
    private String email;

    /**
     * 服务类型
     */
    @TableField(value = "service_classify")
    private Integer serviceClassify;

    /**
     * 服务方式
     */
    @TableField(value = "classify_type")
    private Integer classifyType;

    /**
     * 开始时间
     */
    @TableField(value = "begin_date")
    private String beginDate;

    /**
     * 结束时间
     */
    @TableField(value = "end_date")
    private String endDate;

    /**
     * 服务内容
     */
    @TableField(value = "service_content")
    private String serviceContent;

    /**
     * 客户反馈
     */
    @TableField(value = "customer_feedback")
    private String customerFeedback;

    /**
     * 服务人员
     */
    @TableField(value = "service_staff")
    private String serviceStaff;

    /**
     * 服务评分
     */
    @TableField(value = "service_score")
    private Integer serviceScore;

    /**
     * 附件
     */
    @TableField(value = "file")
    private String file;


}
