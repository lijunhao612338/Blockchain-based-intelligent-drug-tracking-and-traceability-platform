package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.VendorInformation;

import java.util.List;

public interface VendorInformationService extends IService<VendorInformation> {
    public List<VendorInformation> getById(Long id);
}
