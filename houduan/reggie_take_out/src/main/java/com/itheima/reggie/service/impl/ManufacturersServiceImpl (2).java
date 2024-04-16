package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.entity.Information;
import com.itheima.reggie.entity.Manufacturers;
import com.itheima.reggie.mapper.InformationMapper;
import com.itheima.reggie.mapper.ManufacturersMapper;
import com.itheima.reggie.service.InformationService;
import com.itheima.reggie.service.ManufacturersService;
import org.springframework.stereotype.Service;

@Service
public class ManufacturersServiceImpl extends ServiceImpl<ManufacturersMapper, Manufacturers> implements ManufacturersService {
    /**
     * 根据id删除分类
     * @param id
     */
    @Override
    public void remove(Long id) {
        //正常删除分类
        super.removeById(id);
    }
}
