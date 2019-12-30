package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.AllusersMapper;
import com.spring.entity.Allusers;
import com.spring.service.AllusersService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("AllusersService")
public class AllusersServiceImpl extends ServiceBase<Allusers> implements AllusersService {
    @Resource
    private AllusersMapper alluserDao;

    @Override
    protected AllusersMapper getDao() {
        return alluserDao;
    }

    public Allusers login(String username, String password) {
        Allusers user = new Allusers();
        user.setUsername(username);
        user.setPwd(Info.formatPassword(password));

        return this.alluserDao.login(user);
    }

    public boolean updatePassword(int id, String newPassword) {
        Allusers user = new Allusers();
        user.setId(id);
        user.setPwd(Info.formatPassword(newPassword));
        int i = this.alluserDao.updateByPrimaryKeySelective(user);
        return i == 1;
    }

    public Allusers getAllusersById(int id) {
        return this.alluserDao.selectByPrimaryKey(id);
    }
}
