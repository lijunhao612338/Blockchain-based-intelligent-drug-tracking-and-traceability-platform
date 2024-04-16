package com.itheima.reggie.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class DealerInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String drugInformation;

    private String inboundTime;

    private String shippingWarehouse;

    private String sourceCode;

    private String suyuanid;

    private String businessName;

    private String genericName;

    private String dosageForm;

    private String manufacturer;

    private String approvalNumber;

    private String unit;

    private String quantity;

    private String unitPrice;

    private String amount;

    private String lotNumber;

    private String expirationDate;

    private String remark;
}
