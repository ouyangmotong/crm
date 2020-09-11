package com.hy.crm.entity;

/**
 * @author kw
 * @version 1.0
 * @description
 * @date 2020/9/10 14:26 星期四
 */

import java.io.Serializable;

/***
 * 处理商机的bean
 */

public class BusyBean implements Serializable {

    private Integer businessId;
    private Integer clienteleId;
    private String businessname;
    /**
     * 客户名称
     */
    private String  clientelename;

    /**
     * 行业id
     */

    private Integer industrayId;

    /**
     * 所在城市
     */
    private String city;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 客户来源id
     */
    private Integer clienteleSource;

    /**
     * 预计成交金额
     */
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
     * 部门
     */
    private String dept;


    /**
     * 职务
     */
    private String post;


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
     * 商机负责人id
     */
    private String  empname;


    /**
     * 商机所属部门id
     */
    private Integer deptId;


    /**
     * 商机参与人
     */
    private String participator;

    /**
     * 优先级(1001高,1002中,1003低)
     */
    private Integer priorityId;

    /*当前状态(1001初期沟通,1002方案与报价,1003竞争或投标,1004商务谈判,1005成交,1006丢单,1007搁置)*/
    private Integer businessstaticId;

    public Integer getClienteleId() {
        return clienteleId;
    }

    public void setClienteleId(Integer clienteleId) {
        this.clienteleId = clienteleId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public String getClientelename() {
        return clientelename;
    }

    public void setClientelename(String clientelename) {
        this.clientelename = clientelename;
    }

    public Integer getIndustrayId() {
        return industrayId;
    }

    public void setIndustrayId(Integer industrayId) {
        this.industrayId = industrayId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public Integer getClienteleSource() {
        return clienteleSource;
    }

    public void setClienteleSource(Integer clienteleSource) {
        this.clienteleSource = clienteleSource;
    }

    public Integer getEstimatedAmount() {
        return estimatedAmount;
    }

    public void setEstimatedAmount(Integer estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }

    public String getEstimatedDate() {
        return estimatedDate;
    }

    public void setEstimatedDate(String estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrincipalPart() {
        return principalPart;
    }

    public void setPrincipalPart(String principalPart) {
        this.principalPart = principalPart;
    }

    public String getBusinessFile() {
        return businessFile;
    }

    public void setBusinessFile(String businessFile) {
        this.businessFile = businessFile;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getParticipator() {
        return participator;
    }

    public void setParticipator(String participator) {
        this.participator = participator;
    }

    public Integer getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Integer priorityId) {
        this.priorityId = priorityId;
    }

    public Integer getBusinessstaticId() {
        return businessstaticId;
    }

    public void setBusinessstaticId(Integer businessstaticId) {
        this.businessstaticId = businessstaticId;
    }

    @Override
    public String toString() {
        return "BusyBean{" +
                "businessId=" + businessId +
                ", businessName='" + businessname + '\'' +
                ", clientelename='" + clientelename + '\'' +
                ", industrayId=" + industrayId +
                ", city='" + city + '\'' +
                ", adress='" + address + '\'' +
                ", clienteleSource=" + clienteleSource +
                ", estimatedAmount=" + estimatedAmount +
                ", estimatedDate='" + estimatedDate + '\'' +
                ", contacts='" + contacts + '\'' +
                ", dept='" + dept + '\'' +
                ", post='" + post + '\'' +
                ", telephone='" + telephone + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", principalPart='" + principalPart + '\'' +
                ", businessFile='" + businessFile + '\'' +
                ", empname='" + empname + '\'' +
                ", deptId=" + deptId +
                ", participator='" + participator + '\'' +
                ", priorityId=" + priorityId +
                ", businessstaticId=" + businessstaticId +
                '}';
    }
}
