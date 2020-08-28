package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "emp_id", type = IdType.AUTO)
    private Integer empId;

    private String empName;

    /**
     * 密码
     */
    private String empPwd;

    /**
     * 性别
     */
    private String empSex;

    /**
     * 角色
     */
    private Integer roleId;

    /**
     * 年龄
     */
    private Integer empAge;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 部门id
     */
    private Integer deptId;

    /**
     * 狀態
     */
    private Integer empStatic;

    /**
     * 图片
     */
    private String empImg;

    /**
     * 个性签名
     */
    private String signature;


}
