package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.ZhuceyonghuMapper;
import com.spring.entity.Zhuceyonghu;
import com.spring.service.ZhuceyonghuService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("ZhuceyonghuService")
public class ZhuceyonghuServiceImpl extends ServiceBase<Zhuceyonghu> implements ZhuceyonghuService {
    @Resource
    private ZhuceyonghuMapper dao;

    @Override
    protected ZhuceyonghuMapper getDao() {
        return dao;
    }
    public Zhuceyonghu login(String username, String password) {
        Zhuceyonghu user = new Zhuceyonghu();
        user.setYonghuming(username);
        user.setMima(Info.formatPassword(password));

        return this.dao.login(user);
    }

    public boolean updatePassword(int id, String newPassword) {
        Zhuceyonghu user = new Zhuceyonghu();
        user.setId(id);
        user.setMima(Info.formatPassword(newPassword));
        int i = this.dao.updateByPrimaryKeySelective(user);
        return i == 1;
    }
}
