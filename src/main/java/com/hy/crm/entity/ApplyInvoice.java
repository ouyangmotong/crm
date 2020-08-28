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
 * 开票申请表
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ApplyInvoice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 开票申请表id
     */
    @TableId(value = "apply_invoice_id", type = IdType.AUTO)
    private Integer applyInvoiceId;

    /**
     * 主题
     */
    private String headline;

    /**
     * 优先级(1001高,1002中,1003低)
     */
    private Integer priorityId;

    /**
     * 结束时间
     */
    private String endDate;

    /**
     * 申请人id
     */
    private Integer empId;

    /**
     * 所属部门id
     */
    private Integer deptId;

    /**
     * 申请日期
     */
    private String applyDate;

    /**
     * 主要技术条款
     */
    private String technicalClause;

    /**
     * 客户id
     */
    private Integer clienteleId;

    /**
     * 关联合同
     */
    private String contractFile;

    /**
     * 合同id
     */
    private Integer contractId;

    /**
     * 开票种类()
     */
    @TableField("invoice_classifyId")
    private Integer invoiceClassifyid;

    /**
     * 纳税人识别号
     */
    private String taxesNumber;

    /**
     * 开户行及账号
     */
    private String cardNumber;

    /**
     * 地址和电话
     */
    private String address;

    /**
     * 开票金额
     */
    private Integer contractSum;

    /**
     * 金额大写
     */
    private String amountWords;

    /**
     * 开票时间
     */
    private String invoiceDate;

    /**
     * 发票号码
     */
    private String invoiceNumber;

    /**
     * 附件
     */
    private String applyInvoiceFile;


}
