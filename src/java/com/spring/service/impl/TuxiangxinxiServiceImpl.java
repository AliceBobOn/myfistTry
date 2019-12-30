package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.TuxiangxinxiMapper;
import com.spring.entity.Tuxiangxinxi;
import com.spring.service.TuxiangxinxiService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("TuxiangxinxiService")
public class TuxiangxinxiServiceImpl extends ServiceBase<Tuxiangxinxi> implements TuxiangxinxiService {
    @Resource
    private TuxiangxinxiMapper dao;

    @Override
    protected TuxiangxinxiMapper getDao() {
        return dao;
    }
}
