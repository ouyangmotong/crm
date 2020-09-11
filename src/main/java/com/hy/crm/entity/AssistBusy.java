package com.hy.crm.entity;

/**
 * @author kw
 * @version 1.0
 * @description
 * @date 2020/9/7 11:12 星期一
 */

import java.io.Serializable;

/**
 *
 */
public class AssistBusy implements Serializable {
    private Integer businessId;//商机id
    private Integer clienteleId;//客户id
    private String businessName;//商机名称
    private String name;//商机阶段
    private Integer estimatedAmount;//预计成交金额
    private String empname;//商机负责人
    private String documentarydate;//最后跟单时间
    private Integer num;//讨论数
    private String estimateDdate;//预计成交日期
    private String dept;//部门名称

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getClienteleId() {
        return clienteleId;
    }

    public void setClienteleId(Integer clienteleId) {
        this.clienteleId = clienteleId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEstimatedAmount() {
        return estimatedAmount;
    }

    public void setEstimatedAmount(Integer estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getDocumentarydate() {
        return documentarydate;
    }

    public void setDocumentarydate(String documentarydate) {
        this.documentarydate = documentarydate;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getEstimateDdate() {
        return estimateDdate;
    }

    public void setEstimateDdate(String estimateDdate) {
        this.estimateDdate = estimateDdate;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "AssistBusy{" +
                "businessId=" + businessId +
                ", clienteleId=" + clienteleId +
                ", businessName='" + businessName + '\'' +
                ", name='" + name + '\'' +
                ", estimatedAmount=" + estimatedAmount +
                ", empname='" + empname + '\'' +
                ", documentarydate='" + documentarydate + '\'' +
                ", num=" + num +
                ", estimateDdate='" + estimateDdate + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}
