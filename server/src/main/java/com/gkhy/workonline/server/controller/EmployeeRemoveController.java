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

import com.gkhy.workonline.server.entity.EmployeeRemoveEntity;
import com.gkhy.workonline.server.service.EmployeeRemoveService;
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
@RequestMapping("server/employeeremove")
public class EmployeeRemoveController {
    @Autowired
    private EmployeeRemoveService employeeRemoveService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("server:employeeremove:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = employeeRemoveService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("server:employeeremove:info")
    public R info(@PathVariable("id") Integer id){
		EmployeeRemoveEntity employeeRemove = employeeRemoveService.getById(id);

        return R.ok().put("employeeRemove", employeeRemove);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("server:employeeremove:save")
    public R save(@RequestBody EmployeeRemoveEntity employeeRemove){
		employeeRemoveService.save(employeeRemove);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("server:employeeremove:update")
    public R update(@RequestBody EmployeeRemoveEntity employeeRemove){
		employeeRemoveService.updateById(employeeRemove);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("server:employeeremove:delete")
    public R delete(@RequestBody Integer[] ids){
		employeeRemoveService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
