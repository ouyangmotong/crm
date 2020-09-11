package com.hy.crm.entity.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Jackson
 * @date 2020/9/11 14:39
 * @Description:
 */
@Data
public class MyDesktopBo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 客户总和
     */
    private int clienteleNum;
    /**
     * 商机总和
     */
    private int businessNum;
    /**
     * 合同总和
     */
    private int contractNum;
    /**
     * 丢单金额
     */
    private int throwSum;
    /**
     * 搁置金额
     */
    private int shelveSum;
    /**
     * 进行金额
     */
    private int operationSum;
    /**
     * 成交金额
     */
    private int turnover;
}
