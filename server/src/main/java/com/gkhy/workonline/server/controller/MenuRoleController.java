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

import com.gkhy.workonline.server.entity.MenuRoleEntity;
import com.gkhy.workonline.server.service.MenuRoleService;
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
@RequestMapping("server/menurole")
public class MenuRoleController {
    @Autowired
    private MenuRoleService menuRoleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("server:menurole:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = menuRoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("server:menurole:info")
    public R info(@PathVariable("id") Integer id){
		MenuRoleEntity menuRole = menuRoleService.getById(id);

        return R.ok().put("menuRole", menuRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("server:menurole:save")
    public R save(@RequestBody MenuRoleEntity menuRole){
		menuRoleService.save(menuRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("server:menurole:update")
    public R update(@RequestBody MenuRoleEntity menuRole){
		menuRoleService.updateById(menuRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("server:menurole:delete")
    public R delete(@RequestBody Integer[] ids){
		menuRoleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
