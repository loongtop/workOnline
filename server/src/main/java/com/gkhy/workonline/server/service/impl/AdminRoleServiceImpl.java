package com.gkhy.workonline.server.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gkhy.workonline.server.utils.PageUtils;
import com.gkhy.workonline.server.utils.Query;

import com.gkhy.workonline.server.dao.AdminRoleDao;
import com.gkhy.workonline.server.entity.AdminRoleEntity;
import com.gkhy.workonline.server.service.AdminRoleService;


@Service("adminRoleService")
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleDao, AdminRoleEntity> implements AdminRoleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }

}