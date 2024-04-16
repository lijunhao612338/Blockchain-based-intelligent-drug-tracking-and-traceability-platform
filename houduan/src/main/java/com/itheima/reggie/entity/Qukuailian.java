package com.itheima.reggie.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 员工实体
 */
@Data
public class Qukuailian implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String drugName;//药品名称

    private String inboundTime;//入库时间

    private String shippingWarehouse;//发货仓库

    private String genericName;//药品通用名

    private String specification;//规格

    private String dosageForm;//剂型

    private String manufacturer;//生产厂商

    private String approvalNumber;//批准文号

    private String unit;//单位

    private String quantity;//数量

    private String unitPrice;//单价

    private String amount;//金额

    private String lotNumber;//批号

    private String expirationDate;//有效期

    private String remark;//备注

}
