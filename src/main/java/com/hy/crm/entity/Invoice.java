package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 开票表id
     */
    @TableId(value = "invoice_id", type = IdType.AUTO)
    private Integer invoiceId;

    /**
     * 主题
     */
    private String headline;

    /**
     * 主要技术条款
     */
    private String technicalClause;

    /**
     * 客户id
     */
    private Integer clienteleId;

    /**
     * 合同id
     */
    private Integer contractId;

    /**
     * 开票种类(1001普通纸质发票 1002普通电子发票 1003增值税专用纸质发票 1004增值税专用电子发票)
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
