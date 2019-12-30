package com.spring.service;

import com.base.IServiceBase;
import com.spring.entity.Allusers;

public interface AllusersService extends IServiceBase<Allusers> {
    public Allusers login(String username, String password);
    public boolean updatePassword(int id, String newPassword);
    public Allusers getAllusersById(int id);
}
