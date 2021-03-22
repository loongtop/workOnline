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

import com.gkhy.workonline.server.entity.EmployeeTrainEntity;
import com.gkhy.workonline.server.service.EmployeeTrainService;
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
@RequestMapping("server/employeetrain")
public class EmployeeTrainController {
    @Autowired
    private EmployeeTrainService employeeTrainService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("server:employeetrain:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = employeeTrainService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("server:employeetrain:info")
    public R info(@PathVariable("id") Integer id){
		EmployeeTrainEntity employeeTrain = employeeTrainService.getById(id);

        return R.ok().put("employeeTrain", employeeTrain);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("server:employeetrain:save")
    public R save(@RequestBody EmployeeTrainEntity employeeTrain){
		employeeTrainService.save(employeeTrain);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("server:employeetrain:update")
    public R update(@RequestBody EmployeeTrainEntity employeeTrain){
		employeeTrainService.updateById(employeeTrain);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("server:employeetrain:delete")
    public R delete(@RequestBody Integer[] ids){
		employeeTrainService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
