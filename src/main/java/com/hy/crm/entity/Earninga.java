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
 * 收入表
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Earninga implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 收入表id
     */
    @TableId(value = "earning_id", type = IdType.AUTO)
    private Integer earningId;

    /**
     * 收入金额
     */
    private Integer earningNum;

    /**
     * 金额大写
     */
    private String amountWords;

    /**
     * 合同id
     */
    private Integer contractId;

    /**
     * 收入日期
     */
    private String remittanceDate;

    /**
     * 收入分类(1001利息收入,1002投资收益,1003主营业务收入,1004其他业务收入)
     */
    private Integer earningClassifyId;

    /**
     * 收款方式(1001现金,1002银行转账,1003支付宝转账,1004微信转账)
     */
    @TableField("earning_wayId")
    private Integer earningWayid;

    /**
     * 收款人id
     */
    private Integer empId;

    /**
     * 关联人
     */
    private String payer;

    /**
     * 关联部门
     */
    private String payingDepartment;

    /**
     * 对方单位（客户id）
     */
    private String clienteleId;

    /**
     * 收入说明
     */
    private String principalPart;


}
