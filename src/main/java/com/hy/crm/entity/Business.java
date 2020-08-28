package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商机表
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "business_id", type = IdType.AUTO)
    private Integer businessId;

    @TableField("business_Name")
    private String businessName;

    /**
     * 客户id
     */
    private Integer clienteleId;

    /**
     * 客户来源id
     */
    private Integer clienteleSource;

    /**
     * 预计成交金额
     */
    @TableField("estimated_Amount")
    private Integer estimatedAmount;

    /**
     * 预计截单日期
     */
    private String estimatedDate;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 职务
     */
    private String post;

    /**
     * 部门
     */
    private String dept;

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
     * 主要业务需求
     */
    private String principalPart;

    /**
     * 相关附件
     */
    private String businessFile;

    /**
     * 商机所属部门id
     */
    private Integer deptId;

    /**
     * 商机负责人id
     */
    private Integer empId;

    /**
     * 商机参与人
     */
    private String participator;

    /**
     * 优先级(1001高,1002中,1003低)
     */
    private Integer priorityId;

    /**
     * 当前状态(1001初期沟通,1002方案与报价,1003竞争或投标,1004商务谈判,1005成交,1006丢单,1007搁置)
     */
    @TableField("businessStatic_id")
    private Integer businessstaticId;


}
