package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Information;
import com.itheima.reggie.entity.Vendor;

public interface VendorService extends IService<Vendor> {
    public void remove(Long id);
}
