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

import com.gkhy.workonline.server.entity.SysMsgEntity;
import com.gkhy.workonline.server.service.SysMsgService;
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
@RequestMapping("server/sysmsg")
public class SysMsgController {
    @Autowired
    private SysMsgService sysMsgService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("server:sysmsg:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysMsgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("server:sysmsg:info")
    public R info(@PathVariable("id") Integer id){
		SysMsgEntity sysMsg = sysMsgService.getById(id);

        return R.ok().put("sysMsg", sysMsg);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("server:sysmsg:save")
    public R save(@RequestBody SysMsgEntity sysMsg){
		sysMsgService.save(sysMsg);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("server:sysmsg:update")
    public R update(@RequestBody SysMsgEntity sysMsg){
		sysMsgService.updateById(sysMsg);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("server:sysmsg:delete")
    public R delete(@RequestBody Integer[] ids){
		sysMsgService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
