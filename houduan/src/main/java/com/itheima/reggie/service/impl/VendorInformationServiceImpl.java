package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.entity.VendorInformation;
import com.itheima.reggie.mapper.VendorInformationMapper;
import com.itheima.reggie.service.VendorInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorInformationServiceImpl extends ServiceImpl<VendorInformationMapper, VendorInformation> implements VendorInformationService {
    @Autowired
    private VendorInformationMapper vendorInformationMapper;
    @Override
    public List<VendorInformation> getById(Long suyuan) {
        LambdaQueryWrapper<VendorInformation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(VendorInformation::getSuyuanid,suyuan);
        List<VendorInformation> vendorInformation = vendorInformationMapper.selectList(queryWrapper);
        return vendorInformation;
    }
}
