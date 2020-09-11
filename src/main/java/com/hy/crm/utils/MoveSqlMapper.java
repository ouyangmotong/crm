package com.hy.crm.utils;

import com.hy.crm.entity.Assist;
import com.hy.crm.entity.AssistBusy;
import com.hy.crm.entity.Clientele;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

/**
 * @author kw
 * @version 1.0
 * @description
 * @date 2020/9/4 18:55 星期五
 */

public class MoveSqlMapper {

    public String find(@Param("as") Clientele clientele){
        StringBuffer res=new StringBuffer("select * from clientele where 1=1");
        if(clientele!=null){
            if(clientele.getClienteleId()>0){
                res.append(" and client_id="+clientele.getClienteleId()+"");
            }
        }


        return res.toString();

    }


    public String findAll(@Param("p")AssistBusy assistBusy){
        StringBuffer res=new StringBuffer("SELECT t1.`business_id`,t1.`business_Name`,t1.`dept`,t1.`estimated_Amount`,t1.`estimated_date`,t2.`name`,t3.`emp_name`,t4.`documentary_date` FROM \n" +
                "business t1,business_static t2,emp t3,documentary t4 \n" +
                "WHERE \n" +
                "t1.`businessStatic_id`=t2.`id` \n" +
                "AND \n" +
                "t1.`emp_id`=t3.`emp_id` \n" +
                "AND \n" +
                "t1.`business_id`=t4.`business_id` \n" +
                "AND t3.`emp_id`=t4.`emp_id` and 1=1 ");
        if(assistBusy!=null){
            if(!StringUtils.isEmpty(assistBusy.getBusinessName())){
                res.append(" and t1.business_name='"+assistBusy.getBusinessName()+"'");
            }
            if(!StringUtils.isEmpty(assistBusy.getEstimatedAmount())){
                res.append(" and t1.estimated_Amount='"+assistBusy.getEstimatedAmount()+"'");
            }
            if(!StringUtils.isEmpty(assistBusy.getEstimateDdate())){
                res.append(" and t1.estimated_date='"+assistBusy.getEstimateDdate()+"'");
            }
            if(!StringUtils.isEmpty(assistBusy.getDept())){
                res.append(" and t1.dept='"+assistBusy.getDept()+"'");
            }
            if(!StringUtils.isEmpty(assistBusy.getEmpname())){
                res.append(" and t3.emp_name='"+assistBusy.getEmpname()+"'");

            }
            if(!StringUtils.isEmpty(assistBusy.getName())){
                res.append("and t2.name='"+assistBusy.getName()+"'");

            }


        }

        return res.toString();
    }


}
