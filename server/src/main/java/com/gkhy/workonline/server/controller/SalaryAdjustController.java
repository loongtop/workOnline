package com.gkhy.workonline.server.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gkhy.workonline.server.entity.SalaryAdjustEntity;
import com.gkhy.workonline.server.service.SalaryAdjustService;
import com.gkhy.workonline.server.utils.PageUtils;
import com.gkhy.workonline.server.utils.R;



/**
 * 
 *
 * @author leo
 * @email loongtop@gmail.com
 * @date 2021-03-21 14:47:09
 */
@RestController
@RequestMapping("server/salaryadjust")
public class SalaryAdjustController {
    @Autowired
    private SalaryAdjustService salaryAdjustService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("server:salaryadjust:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = salaryAdjustService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("server:salaryadjust:info")
    public R info(@PathVariable("id") Integer id){
		SalaryAdjustEntity salaryAdjust = salaryAdjustService.getById(id);

        return R.ok().put("salaryAdjust", salaryAdjust);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("server:salaryadjust:save")
    public R save(@RequestBody SalaryAdjustEntity salaryAdjust){
		salaryAdjustService.save(salaryAdjust);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("server:salaryadjust:update")
    public R update(@RequestBody SalaryAdjustEntity salaryAdjust){
		salaryAdjustService.updateById(salaryAdjust);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("server:salaryadjust:delete")
    public R delete(@RequestBody Integer[] ids){
		salaryAdjustService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
