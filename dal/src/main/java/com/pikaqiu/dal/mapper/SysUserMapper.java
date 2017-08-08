package com.pikaqiu.dal.mapper;

import com.pikaqiu.dal.model.sysUser;

public interface sysUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(sysUser record);

    int insertSelective(sysUser record);

    sysUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(sysUser record);

    int updateByPrimaryKey(sysUser record);
}