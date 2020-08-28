package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 合同表
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 合同表id
     */
    @TableId(value = "contract_id", type = IdType.AUTO)
    private Integer contractId;

    /**
     * 优先级(1001高,1002中,1003低)
     */
    private Integer priorityId;

    /**
     * 客户信息id
     */
    private Integer clienteleId;

    /**
     * 合同名称
     */
    private String contractName;

    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 合同金额
     */
    private Integer contractSum;

    /**
     * 签约日期
     */
    private String signDate;

    /**
     * 生效日期
     */
    private String validDate;

    /**
     * 服务期至
     */
    private String validityDate;

    /**
     * 对方联系人
     */
    private String contacts;

    /**
     * 固定电话
     */
    private String telephone;

    /**
     * 移动手机
     */
    private String phone;

    /**
     * 邮件/QQ
     */
    private String email;

    /**
     * 主要技术条款
     */
    private String technicalClause;

    /**
     * 主要商务条款
     */
    private String commerceClause;

    /**
     * 相关附件
     */
    private String file;

    /**
     * 合同所属部门id
     */
    private Integer deptId;

    /**
     * 关联人员
     */
    private Integer empId;

    /**
     * 状态(1001完成,1002撤除,1003搁置)
     */
    private Integer contractStatic;


}
