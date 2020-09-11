package com.hy.crm.entity;

import java.io.Serializable;

/**
 * @author kw
 * @version 1.0
 * @description流程处理实体类
 * @date 2020/9/11 9:20 星期五
 */

public class Flow implements Serializable {

    private Integer id;
    private String name;//处理人
    private String content;//信息
    private String issue;//处理时间
    private String status;//处理状态
    private String issuename;//负责人
    private String issuetime;//发布时间

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getIssuename() {
        return issuename;
    }

    public void setIssuename(String issuename) {
        this.issuename = issuename;
    }

    public String getIssuetime() {
        return issuetime;
    }

    public void setIssuetime(String issuetime) {
        this.issuetime = issuetime;
    }
}
