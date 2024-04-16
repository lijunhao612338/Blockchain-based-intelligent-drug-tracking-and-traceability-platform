package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.entity.ManufacturersInformation;
import com.itheima.reggie.mapper.ManufacturersInformationMapper;
import com.itheima.reggie.service.ManufacturersInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturersInformationServiceImpl extends ServiceImpl<ManufacturersInformationMapper, ManufacturersInformation> implements ManufacturersInformationService {
    @Autowired
    private ManufacturersInformationMapper manufacturersInformationMapper;
    @Override
    public List<ManufacturersInformation> getById(Long suyuan) {
        //条件构造器
        LambdaQueryWrapper<ManufacturersInformation> queryWrapper = new LambdaQueryWrapper<>();
        //添加条件
        queryWrapper.eq(ManufacturersInformation::getSuyuanid,suyuan);
        List<ManufacturersInformation> manufacturersInformation = manufacturersInformationMapper.selectList(queryWrapper);
        return manufacturersInformation;
    }
}
