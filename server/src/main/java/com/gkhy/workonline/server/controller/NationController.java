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

import com.gkhy.workonline.server.entity.NationEntity;
import com.gkhy.workonline.server.service.NationService;
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
@RequestMapping("server/nation")
public class NationController {
    @Autowired
    private NationService nationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("server:nation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = nationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("server:nation:info")
    public R info(@PathVariable("id") Integer id){
		NationEntity nation = nationService.getById(id);

        return R.ok().put("nation", nation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("server:nation:save")
    public R save(@RequestBody NationEntity nation){
		nationService.save(nation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("server:nation:update")
    public R update(@RequestBody NationEntity nation){
		nationService.updateById(nation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("server:nation:delete")
    public R delete(@RequestBody Integer[] ids){
		nationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
