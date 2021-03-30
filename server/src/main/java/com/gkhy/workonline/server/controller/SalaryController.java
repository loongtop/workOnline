package com.gkhy.workonline.server.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gkhy.workonline.server.entity.SalaryEntity;
import com.gkhy.workonline.server.service.SalaryService;
import com.gkhy.workonline.server.utils.PageUtils;
import com.gkhy.workonline.server.utils.R;



/**
 * 
 *
 * @author leo
 * @email loongtop@gmail.com
 * @date 2021-03-21 14:47:09
 */
@Api(tags = "banner管理")
@RestController
@RequestMapping("server/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("server:salary:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = salaryService.queryPage(params);
        String str = "leo ok";
        return R.ok().put("page", str);
        //return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("server:salary:info")
    public R info(@PathVariable("id") Integer id){
		SalaryEntity salary = salaryService.getById(id);

        return R.ok().put("salary", salary);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("server:salary:save")
    public R save(@RequestBody SalaryEntity salary){
		salaryService.save(salary);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("server:salary:update")
    public R update(@RequestBody SalaryEntity salary){
		salaryService.updateById(salary);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("server:salary:delete")
    public R delete(@RequestBody Integer[] ids){
		salaryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
