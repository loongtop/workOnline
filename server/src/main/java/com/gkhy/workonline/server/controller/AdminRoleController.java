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

import com.gkhy.workonline.server.entity.AdminRoleEntity;
import com.gkhy.workonline.server.service.AdminRoleService;
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
@RequestMapping("server/adminrole")
public class AdminRoleController {
    @Autowired
    private AdminRoleService adminRoleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("server:adminrole:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = adminRoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("server:adminrole:info")
    public R info(@PathVariable("id") Integer id){
		AdminRoleEntity adminRole = adminRoleService.getById(id);

        return R.ok().put("adminRole", adminRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("server:adminrole:save")
    public R save(@RequestBody AdminRoleEntity adminRole){
		adminRoleService.save(adminRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("server:adminrole:update")
    public R update(@RequestBody AdminRoleEntity adminRole){
		adminRoleService.updateById(adminRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("server:adminrole:delete")
    public R delete(@RequestBody Integer[] ids){
		adminRoleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
