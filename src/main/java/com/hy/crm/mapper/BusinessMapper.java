package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.entity.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.utils.MoveSqlMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * 商机表 Mapper 接口
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Mapper
public interface BusinessMapper extends BaseMapper<Business> {
    @SelectProvider(type=MoveSqlMapper.class,method="findAll")
    public List<AssistBusy> findAllBusy(IPage<AssistBusy> page,@Param("p") AssistBusy assistBusy);
    @Select("SELECT \n" +
            "t1.`business_id` AS businessId,\n" +
            "t1.`clientele_id` AS clienteleId,\n" +
            "t1.`business_Name` AS businessname,\n" +
            "t1.`clientele_source` AS clienteleSource,\n" +
            "t1.`estimated_Amount` AS estimatedAmount,\n" +
            "t1.`estimated_date` AS estimatedDate,\n" +
            "t1.`contacts` AS contacts,\n" +
            "t1.`dept` AS dept,\n" +
            "t1.`post` AS post,\n" +
            "t1.`telephone` AS telephone,\n" +
            "t1.`phone` AS phone,\n" +
            "t1.`email` AS email,\n" +
            "t1.`principal_part` AS principalPart,\n" +
            "t1.`business_file` AS businessFile,\n" +
            "t1.`participator` AS participator,\n" +
            "t1.`dept_id` AS deptId,\n" +
            "t1.`documentary_id` AS priorityId,\n" +
            "t2.`clientele_name` AS clientelename,\n" +
            "t2.`industry_id` AS industrayId,\n" +
            "t2.`city` AS city,\n" +
            "t2.`address` AS address,\n" +
            "t3.`emp_name` AS empname\n" +
            "FROM \n" +
            "business t1,clientele t2,emp t3,dept t4 ,clientele_source t5\n" +
            "WHERE \n" +
            "t5.`clientele_source_id`=t1.`clientele_source`\n" +
            "AND\n" +
            "t1.`clientele_id`=t2.`clientele_id` \n" +
            "AND \n" +
            "t1.`emp_id`=t3.`emp_id` \n" +
            "AND\n" +
            "t1.`dept_id`=t4.`dept_id`\n" +
            "AND \n" +
            "t3.`dept_id`=t4.`dept_id`\n" +
            "AND\n" +
            "t1.`business_id`=#{value}")
    public BusyBean findByIdBusy(Integer id);//根据id查询商机的信息

    @Update("UPDATE \n" +
            "business \n" +
            "SET \n" +
            "business_Name=#{businessName},clientele_source=#{clienteleSource},estimated_Amount=#{estimatedAmount},\n" +
            "estimated_date=#{estimatedDate},contacts=#{contacts},post=#{post},dept=#{dept},telephone=#{telephone},phone=#{phone},\n" +
            "email=#{email},principal_part=#{principalPart},business_file=#{businessFile},dept_id=#{deptId},emp_id=#{empId},participator=#{participator}\n" +
            "priority_id=#{priorityId},businessStatic_id=#{businessstaticId}\n" +
            "WHERE \n" +
            "business_id=#{businessId}")
    public int updateBusiness(Business business);//修改商机

    @Update("UPDATE clientele  SET clientele_name=#{clienteleName},city=#{city},address=#{address},industry_id=#{industryId} WHERE  clientele_id=#{clienteleId}")
    public int updateClient(Clientele clientele);//修改客户信息

    @Update("UPDATE business t1,emp t2  SET t1.`emp_id`=#{empId} WHERE t1.`emp_id`=t2.`emp_id` AND t2.emp_name=#{empName}")
    public int updateEmp(Emp emp);//修改员工id


}
