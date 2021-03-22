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

import com.gkhy.workonline.server.entity.MailLogEntity;
import com.gkhy.workonline.server.service.MailLogService;
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
@RequestMapping("server/maillog")
public class MailLogController {
    @Autowired
    private MailLogService mailLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("server:maillog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = mailLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{msgid}")
    @RequiresPermissions("server:maillog:info")
    public R info(@PathVariable("msgid") String msgid){
		MailLogEntity mailLog = mailLogService.getById(msgid);

        return R.ok().put("mailLog", mailLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("server:maillog:save")
    public R save(@RequestBody MailLogEntity mailLog){
		mailLogService.save(mailLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("server:maillog:update")
    public R update(@RequestBody MailLogEntity mailLog){
		mailLogService.updateById(mailLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("server:maillog:delete")
    public R delete(@RequestBody String[] msgids){
		mailLogService.removeByIds(Arrays.asList(msgids));

        return R.ok();
    }

}
