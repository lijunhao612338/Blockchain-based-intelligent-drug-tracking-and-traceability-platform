package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Information;
import com.itheima.reggie.entity.Manufacturers;

public interface ManufacturersService extends IService<Manufacturers> {
    public void remove(Long id);
}
