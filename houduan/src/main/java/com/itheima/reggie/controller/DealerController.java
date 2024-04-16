package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Dealer;
import com.itheima.reggie.mapper.DealerMapper;
import com.itheima.reggie.service.DealerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
//经销商
@Slf4j
@RestController
@RequestMapping("/vendorManagement")
public class DealerController {

    @Autowired
    private DealerService dealerService;

    @Autowired
    private DealerMapper dealerMapper;

    /**
     * 新增经销商
     * @param
     * @return
     */
    @PostMapping("/addSave1")
    public R<String> save(HttpServletRequest request,@RequestBody Dealer dealer){
        log.info("新增员工，员工信息：{}",dealer.toString());
        dealerService.save(dealer);

        return R.success("新增员工成功");
    }

    /**
     * 经销商信息分页查询
     * @param
     * @param
     * @param
     * @return
     */
    @GetMapping("/page")
    public R<List<Dealer>> page(/*int page,int pageSize,String name*/){
        List<Dealer> dealers = dealerMapper.selectList(null);
        return R.success(dealers);
    }

    /**
     * 点击编辑后根据id查询经销商信息
     * @param id
     * @return
     */
    @GetMapping("/select/{id}")
    public R<Dealer> getById(@PathVariable Long id){
        log.info("根据id查询员工信息...");
        Dealer dealer = dealerService.getById(id);
        if(dealer != null){
            return R.success(dealer);
        }
        return R.error("没有查询到对应员工信息");
    }

    /**
     * 根据id删除经销商信息
     * @param
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public R<String> delete(@PathVariable Long id){
        log.info("删除分类，id为：{}",id);

        //categoryService.removeById(id);
        dealerService.remove(id);

        return R.success("分类信息删除成功");
    }

    /**
     * 根据id修改经销商信息
     * @param dealer
     * @return
     */
    @PostMapping("/editSSave1")
    public R<String> update(HttpServletRequest request,@RequestBody Dealer dealer){
        log.info(dealer.toString());

        long id = Thread.currentThread().getId();
        log.info("线程id为：{}",id);
        //Long empId = (Long)request.getSession().getAttribute("employee");
        //employee.setUpdateTime(LocalDateTime.now());
        //employee.setUpdateUser(empId);
        dealerService.updateById(dealer);

        return R.success("员工信息修改成功");
    }

    /**
     * 多条件查询
     * @param dealer
     * @return
     */
    @GetMapping("/selectby")
    public R<List<Dealer>> select(Dealer dealer){
        System.out.println(dealer.toString());

        //条件构造器
        LambdaQueryWrapper<Dealer> queryWrapper = new LambdaQueryWrapper<>();
        //添加条件
        queryWrapper.eq(dealer.getBusinessName() != null,Dealer::getBusinessName,dealer.getBusinessName())
        .eq(dealer.getBusinessType() != null,Dealer::getBusinessType,dealer.getBusinessType())
        .eq(dealer.getBusinessRegistrationNumber() != null,Dealer::getBusinessRegistrationNumber,dealer.getBusinessRegistrationNumber())
        .eq(dealer.getUnifiedSocialCreditCode() != null,Dealer::getUnifiedSocialCreditCode,dealer.getUnifiedSocialCreditCode())
        .eq(dealer.getRegistrationAuthorities() != null,Dealer::getRegistrationAuthorities,dealer.getRegistrationAuthorities())
        .eq(dealer.getRegion() != null,Dealer::getRegion,dealer.getRegion())
        .eq(dealer.getRegisteredAddress() != null,Dealer::getRegisteredAddress,dealer.getRegisteredAddress())
        .eq(dealer.getCompanyApprovalDate() != null,Dealer::getCompanyApprovalDate,dealer.getCompanyApprovalDate())
        .eq(dealer.getRegisteredCapital() != null,Dealer::getRegisteredCapital,dealer.getRegisteredCapital())
        .eq(dealer.getLegalRepresentative() != null,Dealer::getLegalRepresentative,dealer.getLegalRepresentative())
        .eq(dealer.getContactNumber() != null,Dealer::getContactNumber,dealer.getContactNumber())
        .eq(dealer.getCreateTime() != null,Dealer::getCreateTime,dealer.getCreateTime())
        .eq(dealer.getUpdateTime() != null,Dealer::getUpdateTime,dealer.getUpdateTime())
        .eq(dealer.getCreateUser() != null,Dealer::getCreateUser,dealer.getCreateUser())
        .eq(dealer.getUpdateUser() != null,Dealer::getUpdateUser,dealer.getUpdateUser());
        //添加排序条件
//        queryWrapper.orderByAsc(dealer::getSort).orderByDesc(dealer::getUpdateTime);

        List<Dealer> dealers = dealerService.list(queryWrapper);

        return R.success(dealers);
    }

}
