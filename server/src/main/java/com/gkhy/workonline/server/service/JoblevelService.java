package com.gkhy.workonline.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gkhy.workonline.server.utils.PageUtils;
import com.gkhy.workonline.server.entity.JoblevelEntity;

import java.util.Map;

/**
 * 
 *
 * @author leo
 * @email loongtop@gmail.com
 * @date 2021-03-21 14:47:09
 */
public interface JoblevelService extends IService<JoblevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

