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




    /**
     * 生产商信息分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<List<Manufacturers>> page(/*int page,int pageSize,String name*/){
        List<Manufacturers> manufacturers = manufacturersMapper.selectList(null);
        return R.success(manufacturers);
    }

    /**
     * 新增生产商
     * @param
     * @return
     */
    @PostMapping("addSave2")
    public R<String> save(HttpServletRequest request,@RequestBody Manufacturers manufacturers){
        log.info("新增员工，员工信息：{}",manufacturers.toString());
        manufacturers.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        manufacturersService.save(manufacturers);
        return R.success("新增员工成功");
    }

    /**
     * 根据id修改生产商信息
     * @param manufacturers
     * @return
     */
    @PostMapping("/editSSave3")
    public R<String> update(HttpServletRequest request,@RequestBody Manufacturers manufacturers){
        log.info(manufacturers.toString());
        long id = Thread.currentThread().getId();
        log.info("线程id为：{}",id);
        manufacturersService.updateById(manufacturers);
        return R.success("员工信息修改成功");
    }

    /**
     * 根据id删除生产商信息
     * @param
     * @return
     */
    @DeleteMapping("/delete2/{id}")
    public R<String> delete(@PathVariable Long id){
        log.info("删除分类，id为：{}",id);
        manufacturersService.remove(id);
        return R.success("分类信息删除成功");
    }

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    @GetMapping("/select2/{id}")
    public R<Manufacturers> getById(@PathVariable Long id){
        log.info("根据id查询员工信息...");
        Manufacturers manufacturers = manufacturersService.getById(id);
        if(manufacturers != null){
            return R.success(manufacturers);
        }
        return R.error("没有查询到对应员工信息");
    }


    /**
     * 多条件查询
     * @param
     * @return
     */
    @GetMapping("/selectby")
    public R<List<Manufacturers>> select(Manufacturers manufacturers){
        LambdaQueryWrapper<Manufacturers> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(manufacturers.getBusinessName() != null,Manufacturers::getBusinessName,manufacturers.getBusinessName())
                .eq(manufacturers.getBusinessType() != null,Manufacturers::getBusinessType,manufacturers.getBusinessType())
                .eq(manufacturers.getBusinessRegistrationNumber() != null,Manufacturers::getBusinessRegistrationNumber,manufacturers.getBusinessRegistrationNumber())
                .eq(manufacturers.getUnifiedSocialCreditCode() != null,Manufacturers::getUnifiedSocialCreditCode,manufacturers.getUnifiedSocialCreditCode())
                .eq(manufacturers.getRegisteredAddress() != null,Manufacturers::getRegisteredAddress,manufacturers.getRegisteredAddress())
                .eq(manufacturers.getCompanyApprovalDate() != null,Manufacturers::getCompanyApprovalDate,manufacturers.getCompanyApprovalDate())
                .eq(manufacturers.getRegisteredCapital() != null,Manufacturers::getRegisteredCapital,manufacturers.getRegisteredCapital())
                .eq(manufacturers.getLegalRepresentative() != null,Manufacturers::getLegalRepresentative,manufacturers.getLegalRepresentative())
                .eq(manufacturers.getContactNumber() != null,Manufacturers::getContactNumber,manufacturers.getContactNumber())
                .eq(manufacturers.getCreateTime() != null,Manufacturers::getCreateTime,manufacturers.getCreateTime())
                .eq(manufacturers.getUpdateTime() != null,Manufacturers::getUpdateTime,manufacturers.getUpdateTime())
                .eq(manufacturers.getCreateUser() != null,Manufacturers::getCreateUser,manufacturers.getCreateUser())
                .eq(manufacturers.getUpdateUser() != null,Manufacturers::getUpdateUser,manufacturers.getUpdateUser());
        List<Manufacturers> manufacturers1 = manufacturersService.list(queryWrapper);
        return R.success(manufacturers1);
    }
}
