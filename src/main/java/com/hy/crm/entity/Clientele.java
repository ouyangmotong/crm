package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 客户表
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Clientele implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户id
     */
    @TableId(value = "clientele_id", type = IdType.AUTO)
    private Integer clienteleId;

    private String clienteleName;

    /**
     * 拼音
     */
    private String spell;

    /**
     * 客户分类id
     */
    private Integer classifyId;

    /**
     * 客户来源id
     */
    private Integer clienteleSourceId;

    /**
     * 所属行业id
     */
    private Integer industryId;

    /**
     * 客户网址
     */
    private String clienteleUrl;

    /**
     * 国家/地区
     */
    private String state;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 邮政编码
     */
    private String postcode;

    /**
     * 传真
     */
    private String faxes;

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
     * 办公电话
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
     * 法人代表
     */
    private String corporate;

    /**
     * 注册资本
     */
    private Integer registeredCapital;

    /**
     * 附加说明
     */
    private String principalPart;

    /**
     * 银行账号
     */
    private String bankAccount;

    /**
     * 开户名称
     */
    private String accountName;

    /**
     * 开户银行
     */
    private String accountBank;

    /**
     * 银行地址
     */
    private String bankAddress;

    /**
     * 公司税号
     */
    private String dutyParagraph;

    /**
     * 开户行电话
     */
    private String companyTelephone;


}
