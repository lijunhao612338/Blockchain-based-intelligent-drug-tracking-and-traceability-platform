package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.entity.SuYuan;
import com.itheima.reggie.entity.User;
import com.itheima.reggie.mapper.SuYuanMapper;
import com.itheima.reggie.mapper.UserMapper;
import com.itheima.reggie.service.SuYuanService;
import com.itheima.reggie.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class SuYuanServiceImpl extends ServiceImpl<SuYuanMapper, SuYuan> implements SuYuanService {
}
