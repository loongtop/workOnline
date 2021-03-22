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

import com.gkhy.workonline.server.entity.JoblevelEntity;
import com.gkhy.workonline.server.service.JoblevelService;
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
@RequestMapping("server/joblevel")
public class JoblevelController {
    @Autowired
    private JoblevelService joblevelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("server:joblevel:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = joblevelService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("server:joblevel:info")
    public R info(@PathVariable("id") Integer id){
		JoblevelEntity joblevel = joblevelService.getById(id);

        return R.ok().put("joblevel", joblevel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("server:joblevel:save")
    public R save(@RequestBody JoblevelEntity joblevel){
		joblevelService.save(joblevel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("server:joblevel:update")
    public R update(@RequestBody JoblevelEntity joblevel){
		joblevelService.updateById(joblevel);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("server:joblevel:delete")
    public R delete(@RequestBody Integer[] ids){
		joblevelService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
