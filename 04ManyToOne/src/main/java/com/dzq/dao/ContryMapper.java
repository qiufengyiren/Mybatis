package com.dzq.dao;


import com.dzq.pojo.Provincial;

public interface ContryMapper {
    //多对一
    //根据省会的id查询省会以及国家对应的信息
    Provincial selectByProvincialByPid(Integer id);
}
