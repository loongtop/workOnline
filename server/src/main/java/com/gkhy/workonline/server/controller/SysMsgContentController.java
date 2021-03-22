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

import com.gkhy.workonline.server.entity.SysMsgContentEntity;
import com.gkhy.workonline.server.service.SysMsgContentService;
import com.gkhy.workonline.server.utils.PageUtils;
import com.gkhy.workonline.server.utils.R;



/**
 * 
 *
 * @author leo
 * @email loongtop@gmail.com
 * @date 2021-03-21 14:47:08
 */
@RestController
@RequestMapping("server/sysmsgcontent")
public class SysMsgContentController {
    @Autowired
    private SysMsgContentService sysMsgContentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("server:sysmsgcontent:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysMsgContentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("server:sysmsgcontent:info")
    public R info(@PathVariable("id") Integer id){
		SysMsgContentEntity sysMsgContent = sysMsgContentService.getById(id);

        return R.ok().put("sysMsgContent", sysMsgContent);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("server:sysmsgcontent:save")
    public R save(@RequestBody SysMsgContentEntity sysMsgContent){
		sysMsgContentService.save(sysMsgContent);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("server:sysmsgcontent:update")
    public R update(@RequestBody SysMsgContentEntity sysMsgContent){
		sysMsgContentService.updateById(sysMsgContent);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("server:sysmsgcontent:delete")
    public R delete(@RequestBody Integer[] ids){
		sysMsgContentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
