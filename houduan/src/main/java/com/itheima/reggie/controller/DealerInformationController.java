package com.itheima.reggie.controller;

import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.VendorInformation;
import com.itheima.reggie.mapper.DealerInformationMapper;
import com.itheima.reggie.mapper.VendorInformationMapper;
import com.itheima.reggie.service.DealerInformationService;
import com.itheima.reggie.service.VendorInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//经销商
@Slf4j
@RestController
@RequestMapping("/DealerInformation")
public class DealerInformationController {

    @Autowired
    private DealerInformationService dealerInformationService;

    @Autowired
    private DealerInformationMapper dealerInformationMapper;

    @Autowired
    private VendorInformationService vendorInformationService;

    @Autowired
    private VendorInformationMapper vendorInformationMapper;

    /**
     * 根据id查询经销商入库信息
     * @param id
     * @return
     */
    @GetMapping("/select2/{id}")
    public R<List<VendorInformation>> DealerInformation(@PathVariable Long id){
        List<VendorInformation> vendorInformation = vendorInformationService.getById(id);
        if(vendorInformation != null){
            return R.success(vendorInformation);
        }
        return R.error("没有查询到对应员工信息");
    }

}
