package com.pikaqiu.dal.mapper;

import com.pikaqiu.dal.model.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SysUser record);
}