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

import com.gkhy.workonline.server.entity.EmployeeEcEntity;
import com.gkhy.workonline.server.service.EmployeeEcService;
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
@RequestMapping("server/employeeec")
public class EmployeeEcController {
    @Autowired
    private EmployeeEcService employeeEcService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("server:employeeec:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = employeeEcService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("server:employeeec:info")
    public R info(@PathVariable("id") Integer id){
		EmployeeEcEntity employeeEc = employeeEcService.getById(id);

        return R.ok().put("employeeEc", employeeEc);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("server:employeeec:save")
    public R save(@RequestBody EmployeeEcEntity employeeEc){
		employeeEcService.save(employeeEc);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("server:employeeec:update")
    public R update(@RequestBody EmployeeEcEntity employeeEc){
		employeeEcService.updateById(employeeEc);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("server:employeeec:delete")
    public R delete(@RequestBody Integer[] ids){
		employeeEcService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
