package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Information;
import com.itheima.reggie.entity.Manufacturers;
import com.itheima.reggie.entity.Vendor;
import com.itheima.reggie.mapper.InformationMapper;
import com.itheima.reggie.mapper.ManufacturersMapper;
import com.itheima.reggie.service.InformationService;
import com.itheima.reggie.service.ManufacturersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
//生产商
@Slf4j
@RestController
@RequestMapping("/producerManagement")
public class ManufacturersController {

    @Autowired
    private ManufacturersService manufacturersService;

    @Autowired
    private ManufacturersMapper manufacturersMapper;

//    /**
//     * 员工登录
//     * @param request
//     * @param information
//     * @return
//     */
//    @PostMapping("/login")
//    public R<Information> login(HttpServletRequest request, @RequestBody Information information){
//
//        //1、将页面提交的密码password进行md5加密处理
//        String password = information.getPassword();
//
//        //2、根据页面提交的用户名username查询数据库
//        LambdaQueryWrapper<Information> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(Information::getUsername,information.getUsername());
//        Information emp = informationService.getOne(queryWrapper);
//
//        //3、如果没有查询到则返回登录失败结果
//        if(emp == null){
//            return R.error("登录失败");
//        }
//
//        //4、密码比对，如果不一致则返回登录失败结果
//        if(!emp.getPassword().equals(password)){
//            return R.error("登录失败");
//        }
//
//        //5、查看员工状态，如果为已禁用状态，则返回员工已禁用结果
//        if(emp.getStatus() == 0){
//            return R.error("账号已禁用");
//        }
//
//        //6、登录成功，将员工id存入Session并返回登录成功结果
//        request.getSession().setAttribute("employee",emp.getId());
//        return R.success(emp);
//    }
//
//    /**
//     * 员工退出
//     * @param request
//     * @return
//     */
//    @PostMapping("/logout")
//    public R<String> logout(HttpServletRequest request){
//        //清理Session中保存的当前登录员工的id
//        request.getSession().removeAttribute("employee");
//        return R.success("退出成功");
//    }
//
    /**
     * 新增员工
     * @param
     * @return
     */
    @PostMapping("addSave2")
    public R<String> save(HttpServletRequest request,@RequestBody Manufacturers manufacturers){
        log.info("新增员工，员工信息：{}",manufacturers.toString());

        //设置初始密码123456，需要进行md5加密处理
        manufacturers.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

        //employee.setCreateTime(LocalDateTime.now());
        //employee.setUpdateTime(LocalDateTime.now());

        //获得当前登录用户的id
        //Long empId = (Long) request.getSession().getAttribute("employee");

        //employee.setCreateUser(empId);
        //employee.setUpdateUser(empId);

        manufacturersService.save(manufacturers);

        return R.success("新增员工成功");
    }

    /**
     * 员工信息分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<List<Manufacturers>> page(/*int page,int pageSize,String name*/){
//        log.info("page = {},pageSize = {},name = {}" ,page,pageSize,name);

//        //构造分页构造器
//        Page pageInfo = new Page(page,pageSize);
//
//        //构造条件构造器
//        LambdaQueryWrapper<Information> queryWrapper = new LambdaQueryWrapper();
//        //添加过滤条件
//        queryWrapper.like(StringUtils.isNotEmpty(name), Information::getName,name);
//        //添加排序条件
//        queryWrapper.orderByDesc(Information::getUpdateTime);
//
//        //执行查询
//        informationService.page(pageInfo,queryWrapper);
//
//        return R.success(pageInfo);
        List<Manufacturers> manufacturers = manufacturersMapper.selectList(null);
        return R.success(manufacturers);
    }

    /**
     * 根据id修改员工信息
     * @param information
     * @return
     */
    @PostMapping("/editSSave3")
    public R<String> update(HttpServletRequest request,@RequestBody Manufacturers manufacturers){
        log.info(manufacturers.toString());

        long id = Thread.currentThread().getId();
        log.info("线程id为：{}",id);
        //Long empId = (Long)request.getSession().getAttribute("employee");
        //employee.setUpdateTime(LocalDateTime.now());
        //employee.setUpdateUser(empId);
        manufacturersService.updateById(manufacturers);

        return R.success("员工信息修改成功");
    }
//
//    /**
//     * 根据id查询员工信息
//     * @param id
//     * @return
//     */
//    @GetMapping("/{id}")
//    public R<Information> getById(@PathVariable Long id){
//        log.info("根据id查询员工信息...");
//        Information information = informationService.getById(id);
//        if(information != null){
//            return R.success(information);
//        }
//        return R.error("没有查询到对应员工信息");
//    }

    @DeleteMapping("/delete2/{id}")
    public R<String> delete(@PathVariable Long id){
        log.info("删除分类，id为：{}",id);

        //categoryService.removeById(id);
        manufacturersService.remove(id);

        return R.success("分类信息删除成功");
    }

    @GetMapping("/select2/{id}")
    public R<Manufacturers> getById(@PathVariable Long id){
        log.info("根据id查询员工信息...");
        Manufacturers manufacturers = manufacturersService.getById(id);
        if(manufacturers != null){
            return R.success(manufacturers);
        }
        return R.error("没有查询到对应员工信息");
    }
}
