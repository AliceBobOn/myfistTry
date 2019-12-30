package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.TuxiangfenleiMapper;
import com.spring.entity.Tuxiangfenlei;
import com.spring.service.TuxiangfenleiService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("TuxiangfenleiService")
public class TuxiangfenleiServiceImpl extends ServiceBase<Tuxiangfenlei> implements TuxiangfenleiService {
    @Resource
    private TuxiangfenleiMapper dao;

    @Override
    protected TuxiangfenleiMapper getDao() {
        return dao;
    }
}
