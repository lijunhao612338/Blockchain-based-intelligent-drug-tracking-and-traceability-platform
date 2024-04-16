package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Dealer;
import com.itheima.reggie.entity.Information;

public interface DealerService extends IService<Dealer> {
    public void remove(Long id);
}
