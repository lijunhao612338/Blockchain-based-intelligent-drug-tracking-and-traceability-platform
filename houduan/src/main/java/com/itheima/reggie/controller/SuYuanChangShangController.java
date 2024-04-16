package com.itheima.reggie.controller;

import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.ManufacturersInformation;
import com.itheima.reggie.entity.SuYuanChangShang;
import com.itheima.reggie.mapper.SuYuanChangShangMapper;
import com.itheima.reggie.mapper.VendorInformationMapper;
import com.itheima.reggie.service.SuYuanChangShangService;
import com.itheima.reggie.service.VendorInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/SuYuanChangShang")
public class SuYuanChangShangController {
    @Autowired
    private SuYuanChangShangService suYuanChangShangService;

    @Autowired
    private SuYuanChangShangMapper suYuanChangShangMapper;
    /**
     * 根据suyuanid查询三个厂商
     * @param suyuanid
     * @return
     */
    @GetMapping("/select3/{suyuanid}")
    public R<SuYuanChangShang> getChangShangInformation(@PathVariable Long suyuanid){
        SuYuanChangShang byId = suYuanChangShangService.getById(suyuanid);
        if(byId.toString() != null){
            return R.success(byId);
        }
        return R.error("没有查询到对应员工信息");
    }
}
