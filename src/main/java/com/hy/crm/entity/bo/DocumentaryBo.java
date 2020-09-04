package com.hy.crm.entity.bo;

import lombok.Data;

/**
 * <p>
 * 商机状态(跟单)
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Data
public class DocumentaryBo{
    private Integer documentaryId;//跟单id
    private Integer businessId;//商机id
    private String businessName;//跟单主题(商机名称)
    private String documentaryDate;//跟单日期
    private Integer documentaryType;//跟单分类(1001电话沟通,1002邮件联系,1003网上交流,1004上面拜访,1005产品送样,1006客户招待,1007其他)
    private String documentaryTypeName;//跟单份分类
    private Integer empId;//跟单人id
    private String empName;//跟单人名称
    private String documentaryData;//跟单内容
    private String file;//附件
}
