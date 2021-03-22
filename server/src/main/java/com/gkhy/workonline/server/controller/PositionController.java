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

import com.gkhy.workonline.server.entity.PositionEntity;
import com.gkhy.workonline.server.service.PositionService;
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
@RequestMapping("server/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("server:position:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = positionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("server:position:info")
    public R info(@PathVariable("id") Integer id){
		PositionEntity position = positionService.getById(id);

        return R.ok().put("position", position);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("server:position:save")
    public R save(@RequestBody PositionEntity position){
		positionService.save(position);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("server:position:update")
    public R update(@RequestBody PositionEntity position){
		positionService.updateById(position);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("server:position:delete")
    public R delete(@RequestBody Integer[] ids){
		positionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
