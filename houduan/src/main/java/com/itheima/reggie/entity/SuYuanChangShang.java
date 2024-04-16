package com.itheima.reggie.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SuYuanChangShang {
    @TableId(value = "suyuanid",type = IdType.AUTO)
    private Long suyuanid;



    private String dealerName;



    private String manufacturersName;



    private String vendorName;


}
