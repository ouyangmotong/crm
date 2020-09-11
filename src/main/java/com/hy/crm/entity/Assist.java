package com.hy.crm.entity;

import java.io.Serializable;

/**
 * @author kw
 * @version 1.0
 * @description 辅助类用于客户管理
 * @date 2020/9/4 14:40 星期五
 */

public class Assist implements Serializable {
    private int aid;//客户管理id
    private String clienteleName;//客户名称
    private int busNum;//商机数
    private int estimatedAmount;//预计成交金额
    private int consNum;//合同数
    private int contractSum;//合同金额
    private  int backmoney;//回款金额
    private  int salesNum;//售后服务数
    private int  serviceScore;//服务分数

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getClienteleName() {
        return clienteleName;
    }

    public void setClienteleName(String clienteleName) {
        this.clienteleName = clienteleName;
    }

    public int getBusNum() {
        return busNum;
    }

    public void setBusNum(int busNum) {
        this.busNum = busNum;
    }

    public int getEstimatedAmount() {
        return estimatedAmount;
    }

    public void setEstimatedAmount(int estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }

    public int getConsNum() {
        return consNum;
    }

    public void setConsNum(int consNum) {
        this.consNum = consNum;
    }

    public int getContractSum() {
        return contractSum;
    }

    public void setContractSum(int contractSum) {
        this.contractSum = contractSum;
    }

    public int getBackmoney() {
        return backmoney;
    }

    public void setBackmoney(int backmoney) {
        this.backmoney = backmoney;
    }

    public int getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(int salesNum) {
        this.salesNum = salesNum;
    }

    public int getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(int serviceScore) {
        this.serviceScore = serviceScore;
    }

    @Override
    public String toString() {
        return "Assist{" +
                "aid=" + aid +
                ", clienteleName='" + clienteleName + '\'' +
                ", busNum=" + busNum +
                ", estimatedAmount=" + estimatedAmount +
                ", consNum=" + consNum +
                ", contractSum=" + contractSum +
                ", backmoney=" + backmoney +
                ", salesNum=" + salesNum +
                ", serviceScore=" + serviceScore +
                '}';
    }
}
