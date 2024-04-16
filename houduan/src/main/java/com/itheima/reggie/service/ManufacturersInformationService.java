package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.ManufacturersInformation;

import java.util.List;

public interface ManufacturersInformationService extends IService<ManufacturersInformation> {
    public List<ManufacturersInformation> getById(Long suyuan);
}
