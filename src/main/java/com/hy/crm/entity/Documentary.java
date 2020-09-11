package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author kw
 * @version 1.0
 * @description
 * @date 2020/9/7 15:44 星期一
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "documentary")
public class Documentary implements Serializable {
  @TableId(value="documentary_id",type = IdType.AUTO)
  private Integer  documentaryid;
    @TableField(value="business_id ")
   private Integer  businessid;
    @TableField(value = "business_Name")
   private String  businessName;
    @TableField(value ="documentary_date")
   private String  documentarydate;
    @TableField(value = "documentary_type")
   private Integer documentarytype;
    @TableField(value="emp_id")
   private Integer  empid;
    @TableField(value="emp_name")
   private String  empname;
    @TableField(value="documentary_data")
   private  String  documentarydata;
    @TableField(value="file")
   private  String  file;

 public Integer getDocumentaryid() {
  return documentaryid;
 }

 public void setDocumentaryid(Integer documentaryid) {
  this.documentaryid = documentaryid;
 }

 public Integer getBusinessid() {
  return businessid;
 }

 public void setBusinessid(Integer businessid) {
  this.businessid = businessid;
 }

 public String getBusinessName() {
  return businessName;
 }

 public void setBusinessName(String businessName) {
  this.businessName = businessName;
 }

 public String getDocumentarydate() {
  return documentarydate;
 }

 public void setDocumentarydate(String documentarydate) {
  this.documentarydate = documentarydate;
 }

 public Integer getDocumentarytype() {
  return documentarytype;
 }

 public void setDocumentarytype(Integer documentarytype) {
  this.documentarytype = documentarytype;
 }

 public Integer getEmpid() {
  return empid;
 }

 public void setEmpid(Integer empid) {
  this.empid = empid;
 }

 public String getEmpname() {
  return empname;
 }

 public void setEmpname(String empname) {
  this.empname = empname;
 }

 public String getDocumentarydata() {
  return documentarydata;
 }

 public void setDocumentarydata(String documentarydata) {
  this.documentarydata = documentarydata;
 }

 public String getFile() {
  return file;
 }

 public void setFile(String file) {
  this.file = file;
 }
}
