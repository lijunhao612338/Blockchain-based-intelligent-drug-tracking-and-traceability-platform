package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Dealer;
import com.itheima.reggie.entity.Information;
import com.itheima.reggie.entity.Vendor;
import com.itheima.reggie.mapper.InformationMapper;
import com.itheima.reggie.mapper.VendorMapper;
import com.itheima.reggie.service.InformationService;
import com.itheima.reggie.service.VendorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
//供应商
@Slf4j
@RestController
@RequestMapping("/Management")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @Autowired
    private VendorMapper vendorMapper;

    /**
     * 新增员工
     * @param
     * @return
     */
    @PostMapping("addSave3")
    public R<String> save(HttpServletRequest request,@RequestBody Vendor vendor){
        log.info("新增员工，员工信息：{}",vendor.toString());
        vendor.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        vendorService.save(vendor);
        return R.success("新增员工成功");
    }

    /**
     * 员工信息分页查询
     * @param
     * @param
     * @param
     * @return
     */
    @GetMapping("/page")
    public R<List<Vendor>> page(/*int page,int pageSize,String name*/){

        List<Vendor> vendors = vendorMapper.selectList(null);
        return R.success(vendors);
    }

    @DeleteMapping("/delete1/{id}")
    public R<String> delete(@PathVariable Long id){
        log.info("删除分类，id为：{}",id);
        vendorService.remove(id);
        return R.success("分类信息删除成功");
    }

    @GetMapping("/select1/{id}")
    public R<Vendor> getById(@PathVariable Long id){
        log.info("根据id查询员工信息...");
        Vendor vendor = vendorService.getById(id);
        if(vendor != null){
            return R.success(vendor);
        }
        return R.error("没有查询到对应员工信息");
    }

    /**
     * 根据id修改员工信息
     * @param vendor
     * @return
     */
    @PostMapping("/editSSave2")
    public R<String> update(HttpServletRequest request,@RequestBody Vendor vendor){
        log.info(vendor.toString());
        long id = Thread.currentThread().getId();
        log.info("线程id为：{}",id);
        vendorService.updateById(vendor);
        return R.success("员工信息修改成功");
    }


    /**
     * 多条件查询
     * @param vendor
     * @return
     */
    @GetMapping("/selectby")
    public R<List<Vendor>> select(Vendor vendor){

        //条件构造器
        LambdaQueryWrapper<Vendor> queryWrapper = new LambdaQueryWrapper<>();
        //添加条件
        queryWrapper.eq(vendor.getBusinessName() != null,Vendor::getBusinessName,vendor.getBusinessName())
                .eq(vendor.getBusinessType() != null,Vendor::getBusinessType,vendor.getBusinessType())
                .eq(vendor.getBusinessRegistrationNumber() != null,Vendor::getBusinessRegistrationNumber,vendor.getBusinessRegistrationNumber())
                .eq(vendor.getUnifiedSocialCreditCode() != null,Vendor::getUnifiedSocialCreditCode,vendor.getUnifiedSocialCreditCode())
                .eq(vendor.getRegisteredAddress() != null,Vendor::getRegisteredAddress,vendor.getRegisteredAddress())
                .eq(vendor.getCompanyApprovalDate() != null,Vendor::getCompanyApprovalDate,vendor.getCompanyApprovalDate())
                .eq(vendor.getRegisteredCapital() != null,Vendor::getRegisteredCapital,vendor.getRegisteredCapital())
                .eq(vendor.getLegalRepresentative() != null,Vendor::getLegalRepresentative,vendor.getLegalRepresentative())
                .eq(vendor.getContactNumber() != null,Vendor::getContactNumber,vendor.getContactNumber())
                .eq(vendor.getCreateTime() != null,Vendor::getCreateTime,vendor.getCreateTime())
                .eq(vendor.getUpdateTime() != null,Vendor::getUpdateTime,vendor.getUpdateTime())
                .eq(vendor.getCreateUser() != null,Vendor::getCreateUser,vendor.getCreateUser())
                .eq(vendor.getUpdateUser() != null,Vendor::getUpdateUser,vendor.getUpdateUser());
        //添加排序条件
//        queryWrapper.orderByAsc(dealer::getSort).orderByDesc(dealer::getUpdateTime);

        List<Vendor> dealers = vendorService.list(queryWrapper);

        return R.success(dealers);
    }
}
