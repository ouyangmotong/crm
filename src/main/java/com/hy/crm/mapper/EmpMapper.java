package com.hy.crm.mapper;

import com.hy.crm.entity.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {
    @SelectKey(statement = "select LAST_INSERT_ID()", before = false, resultType = int.class, keyProperty = "empId")
    @Insert("insert into emp(emp_name,emp_pwd,emp_sex,role_id,emp_age,phone,birthday,email,dept_id,emp_img) values (#{empName},#{empPwd},#{empSex},#{roleId},#{empAge},#{phone},#{birthday},#{email},#{deptId},#{empImg})")
    public int insertEmp(Emp emp);
    @Insert("insert into crm_emp_role (emp_id,role_name) values(#{arg0},#{arg1})")
    public int insertRoleEmp(Integer empid,String  roleName);
    @Select("select * from emp where emp_name=#{value}")
    public List<Emp> findByName(String name);

    @Select("SELECT * FROM emp t1,business t2 WHERE t1.`emp_id`=t2.`emp_id` AND t2.`emp_id`=#{value}")
    public List<Emp> findById(Integer id);


}