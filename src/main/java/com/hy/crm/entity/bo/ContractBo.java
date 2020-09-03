package com.hy.crm.entity.bo;

import lombok.Data;

/**
 * <p>
 * 合同表
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Data
public class ContractBo {
    private Integer contractId;//合同表id
    private Integer priorityId;//优先级(1001高,1002中,1003低)
    private Integer clienteleId;//客户信息id
    private String contractName;//合同名称
    private String contractNo;//合同编号
    private Integer contractSum;//合同金额
    private Integer earningNum;//汇款额
    private Integer address;//开票额
    private String signDate;//签约日期
    private String validDate;//生效日期
    private String validityDate;//服务期至
    private String contacts;//对方联系人
    private String telephone;//固定电话
    private String phone;//移动手机
    private String email;//邮件/QQ
    private String technicalClause;//主要技术条款
    private String commerceClause;//主要商务条款
    private String file;//相关附件
    private Integer deptId;//合同所属部门id
    private Integer empId;//关联人员
    private Integer contractStatic;//状态(1001完成,1002撤除,1003搁置)

}
