package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.management.ValueExp;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value="emp")
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "emp_id", type = IdType.AUTO)
    private Integer empId;
    @TableField(value="emp_name")
    private String empName;

    /**
     * 密码
     */
    @TableField(value="emp_pwd")
    private String empPwd;

    /**
     * 性别
     */
    @TableField(value="emp_sex")
    private String empSex;

    /**
     * 角色
     */
    @TableField(value="role_id")
    private Integer roleId;
    /**
     * 角色名称
     */
    /**
     * 年龄
     */
    @TableField(value="emp_age")
    private Integer empAge;


    /**
     * 手机号
     */
    @TableField(value="phone")
    private String phone;

    /**
     * 生日
     */
    @TableField(value="birthday")
    private String birthday;

    /**
     * 邮箱
     */
    @TableField(value="email")
    private String email;

    /**
     * 部门id
     */
    @TableField(value="dept_id")
    private Integer deptId;

    /**
     * 狀態
     */
    private Integer empStatic;

    /**
     * 图片
     */
    @TableField(value="emp_img")
    private String empImg;

    /**
     * 个性签名
     */
    private String signature;


}
