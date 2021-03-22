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

import com.gkhy.workonline.server.entity.AppraiseEntity;
import com.gkhy.workonline.server.service.AppraiseService;
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
@RequestMapping("server/appraise")
public class AppraiseController {
    @Autowired
    private AppraiseService appraiseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("server:appraise:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = appraiseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("server:appraise:info")
    public R info(@PathVariable("id") Integer id){
		AppraiseEntity appraise = appraiseService.getById(id);

        return R.ok().put("appraise", appraise);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("server:appraise:save")
    public R save(@RequestBody AppraiseEntity appraise){
		appraiseService.save(appraise);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("server:appraise:update")
    public R update(@RequestBody AppraiseEntity appraise){
		appraiseService.updateById(appraise);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("server:appraise:delete")
    public R delete(@RequestBody Integer[] ids){
		appraiseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
