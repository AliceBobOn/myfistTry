package com.spring.dao;

import com.base.MapperBase;
import com.spring.entity.Zhuceyonghu;

import org.springframework.stereotype.Repository;


@Repository
public interface ZhuceyonghuMapper extends MapperBase<Zhuceyonghu> {
    Zhuceyonghu login(Zhuceyonghu zhuceyonghu);
}
