package com.spring.service;

import com.base.IServiceBase;
import com.spring.entity.Zhuceyonghu;

public interface ZhuceyonghuService extends IServiceBase<Zhuceyonghu> {
    public Zhuceyonghu login(String username, String password);
    public boolean updatePassword(int id, String newPassword);
}
