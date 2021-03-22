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

import com.gkhy.workonline.server.entity.PoliticsStatusEntity;
import com.gkhy.workonline.server.service.PoliticsStatusService;
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
@RequestMapping("server/politicsstatus")
public class PoliticsStatusController {
    @Autowired
    private PoliticsStatusService politicsStatusService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("server:politicsstatus:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = politicsStatusService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("server:politicsstatus:info")
    public R info(@PathVariable("id") Integer id){
		PoliticsStatusEntity politicsStatus = politicsStatusService.getById(id);

        return R.ok().put("politicsStatus", politicsStatus);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("server:politicsstatus:save")
    public R save(@RequestBody PoliticsStatusEntity politicsStatus){
		politicsStatusService.save(politicsStatus);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("server:politicsstatus:update")
    public R update(@RequestBody PoliticsStatusEntity politicsStatus){
		politicsStatusService.updateById(politicsStatus);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("server:politicsstatus:delete")
    public R delete(@RequestBody Integer[] ids){
		politicsStatusService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
