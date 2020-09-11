package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * @author kw
 * @version 1.0
 * @description角色实体类
 * @date 2020/9/1 20:40 星期二
 */
@TableName(value="crm_emp_role")
public class Role  implements Serializable {
    @TableId(value="rid",type = IdType.AUTO)
    private Integer rid;
    @TableField(value="emp_id")
    private int empid;
    @TableField(value = "role_name")
    private String rolename;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
