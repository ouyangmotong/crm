package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author kw
 * @version 1.0
 * @description
 * @date 2020/9/2 11:58 星期三
 */
@TableName(value="crm_emp_role")
public class CrmRoleEmp {
    @TableField(value = "emp_id")
    private Integer emp_id;
    @TableField(value = "crid")
    private Integer crid;

}
