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

import com.gkhy.workonline.server.entity.OplogEntity;
import com.gkhy.workonline.server.service.OplogService;
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
@RequestMapping("server/oplog")
public class OplogController {
    @Autowired
    private OplogService oplogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("server:oplog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = oplogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("server:oplog:info")
    public R info(@PathVariable("id") Integer id){
		OplogEntity oplog = oplogService.getById(id);

        return R.ok().put("oplog", oplog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("server:oplog:save")
    public R save(@RequestBody OplogEntity oplog){
		oplogService.save(oplog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("server:oplog:update")
    public R update(@RequestBody OplogEntity oplog){
		oplogService.updateById(oplog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("server:oplog:delete")
    public R delete(@RequestBody Integer[] ids){
		oplogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
