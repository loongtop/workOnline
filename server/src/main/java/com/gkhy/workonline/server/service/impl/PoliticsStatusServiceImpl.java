package com.gkhy.workonline.server.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gkhy.workonline.server.utils.PageUtils;
import com.gkhy.workonline.server.utils.Query;

import com.gkhy.workonline.server.dao.PoliticsStatusDao;
import com.gkhy.workonline.server.entity.PoliticsStatusEntity;
import com.gkhy.workonline.server.service.PoliticsStatusService;


@Service("politicsStatusService")
public class PoliticsStatusServiceImpl extends ServiceImpl<PoliticsStatusDao, PoliticsStatusEntity> implements PoliticsStatusService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }

}