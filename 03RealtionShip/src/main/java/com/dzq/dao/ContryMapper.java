package com.dzq.dao;

import com.dzq.pojo.Country;

public interface ContryMapper {
    //根据国家的id查询省会的信息
    Country selectByCountryByCid(Integer id);
}
