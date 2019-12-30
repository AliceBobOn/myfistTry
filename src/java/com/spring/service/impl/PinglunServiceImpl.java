package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.PinglunMapper;
import com.spring.entity.Pinglun;
import com.spring.service.PinglunService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import javax.annotation.Resource;


@Service("PinglunService")
public class PinglunServiceImpl extends ServiceBase<Pinglun> implements PinglunService {
    @Resource
    protected PinglunMapper dao;

    @Override
    protected Mapper<Pinglun> getDao() {
        return dao;
    }
}
