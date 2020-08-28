package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
     * 状态(1001已登记待处理,1002处理中,1003已完成)
     */
    private Integer aftStatic;

    /**
     * 责任人id
     */
    private Integer empId;

    /**
     * 客户id
     */
    private Integer clienteleId;

    /**
     * 合同id
     */
    private Integer contractId;

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
     * 服务类型
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
