package com.spring.dao;

import com.base.MapperBase;
import com.spring.entity.Allusers;

import org.springframework.stereotype.Repository;


@Repository
public interface AllusersMapper extends MapperBase<Allusers> {

    Allusers login(Allusers allusers);
}