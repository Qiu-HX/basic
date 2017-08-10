package com.pikaqiu.dal.mapper;

import com.pikaqiu.dal.model.SysMenu;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(SysMenu record);
}