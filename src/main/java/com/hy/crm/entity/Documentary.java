package com.hy.crm.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 商机状态(跟单)
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Documentary implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 跟单id
     */
    private Integer documentaryId;

    /**
     * 商机id
     */
    private Integer businessId;

    /**
     * 跟单主题(商机名称)
     */
    private String businessName;

    /**
     * 跟单日期
     */
    private String documentaryDate;

    /**
     * 跟单分类(1001电话沟通,1002邮件联系,1003网上交流,1004上面拜访,1005产品送样,1006客户招待,1007其他)
     */
    private Integer documentaryType;

    /**
     * 跟单人id
     */
    private Integer empId;

    /**
     * 跟单人名称
     */
    private String empName;

    /**
     * 跟单内容
     */
    private String documentaryData;

    /**
     * 附件
     */
    private String file;

}
