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
public class Vendor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String username;

    private String password;

    private String phone;

    private String sex;

    private String idNumber;//身份证号码

    private String status;

    private String businessName;

    private String businessType;

    private String businessRegistrationNumber;

    private String unifiedSocialCreditCode;

    private String registrationAuthorities;

    private String region;

    private String registeredAddress;

    private String companyApprovalDate;

    private String registeredCapital;

    private String legalRepresentative;

    private String contactNumber;

    private String suyuanid;
    //登记状态
    private String registrationStatus;

    @TableField(fill = FieldFill.INSERT) //插入时填充字段
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) //插入和更新时填充字段
    private LocalDateTime updateTime;

//    @TableField(fill = FieldFill.INSERT) //插入时填充字段
    private String createUser;

//    @TableField(fill = FieldFill.INSERT_UPDATE) //插入和更新时填充字段
    private String updateUser;

}
