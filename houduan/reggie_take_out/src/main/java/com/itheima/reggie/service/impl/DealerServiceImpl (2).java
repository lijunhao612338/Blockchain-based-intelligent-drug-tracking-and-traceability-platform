package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.common.CustomException;
import com.itheima.reggie.entity.Dealer;
import com.itheima.reggie.entity.Dish;
import com.itheima.reggie.entity.Information;
import com.itheima.reggie.entity.Setmeal;
import com.itheima.reggie.mapper.DealerMapper;
import com.itheima.reggie.mapper.InformationMapper;
import com.itheima.reggie.service.DealerService;
import com.itheima.reggie.service.DishService;
import com.itheima.reggie.service.InformationService;
import com.itheima.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealerServiceImpl extends ServiceImpl<DealerMapper, Dealer> implements DealerService {

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
