package com.itheima.reggie.controller;

import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.ManufacturersInformation;
import com.itheima.reggie.entity.VendorInformation;
import com.itheima.reggie.mapper.ManufacturersInformationMapper;
import com.itheima.reggie.mapper.VendorInformationMapper;
import com.itheima.reggie.service.ManufacturersInformationService;
import com.itheima.reggie.service.VendorInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//经销商
@Slf4j
@RestController
@RequestMapping("/VendorInformation")
public class VendorInformationController {
    @Autowired
    private VendorInformationService vendorInformationService;

    @Autowired
    private VendorInformationMapper vendorInformationMapper;

    @Autowired
    private ManufacturersInformationService manufacturersInformationService;

    @Autowired
    private ManufacturersInformationMapper manufacturersInformationMapper;
    /**
     * 根据id查询供应商入库信息
     * @param id
     * @return
     */
    @GetMapping("/select1/{id}")
    public R<List<ManufacturersInformation>> getVendorInformation(@PathVariable Long id){
        List<ManufacturersInformation> manufacturersInformation=manufacturersInformationService.getById(id);
        if(manufacturersInformation != null){
            return R.success(manufacturersInformation);
        }
        return R.error("没有查询到对应员工信息");
    }
    /**
     * 根据id查询供应商出库信息
     * @param id
     * @return
     */
    @GetMapping("/select2/{id}")
    public R<List<VendorInformation>> getById(@PathVariable Long id){
        List<VendorInformation> vendorInformation = vendorInformationService.getById(id);
        if(vendorInformation != null){
            return R.success(vendorInformation);
        }
        return R.error("没有查询到对应员工信息");
    }
}
