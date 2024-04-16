package com.itheima.reggie.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 员工实体
 */
@Data
public class Dealer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String username;

    private String password;

    private String phone;

    private String sex;

    private String idNumber;//身份证号码

    private String status;

    private String businessName;//企业名称

    private String businessType;//企业类型

    private String businessRegistrationNumber;//工商注册号

    private String unifiedSocialCreditCode;//统一社会信用代码

    private String registrationAuthorities;//登记机关

    private String region;//所属地区

    private String registeredAddress;//注册地址

    private String companyApprovalDate;//公司核准日期

    private String registeredCapital;//注册资本

    private String legalRepresentative;//法定代表人

    private String contactNumber;//联系电话

    private String registrationStatus;//登记状态

    private String suyuanid;
    @TableField(fill = FieldFill.INSERT) //插入时填充字段
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) //插入和更新时填充字段
    private LocalDateTime updateTime;

//    @TableField(fill = FieldFill.INSERT) //插入时填充字段
    private String createUser;
//
//    @TableField(fill = FieldFill.INSERT_UPDATE) //插入和更新时填充字段
    private String updateUser;

}
