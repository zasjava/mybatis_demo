package com.mybatis.mapper;

import com.mybatis.pojo.RoleTest;

public interface RoleTestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleTest record);

    int insertSelective(RoleTest record);

    RoleTest selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleTest record);

    int updateByPrimaryKey(RoleTest record);
}