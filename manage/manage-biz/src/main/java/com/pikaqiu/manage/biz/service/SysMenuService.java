package com.pikaqiu.manage.biz.service;

import com.pikaqiu.dal.model.SysMenu;

/**
 * Created by user on 2017/8/10.
 */
public interface SysMenuService {
    /**
     * 新增菜单
     * @param sysMenu
     */
    void insertUser(SysMenu sysMenu);

    /**
     * 更新菜单
     * @param sysMenu
     */
    void updateUser(SysMenu sysMenu);
}
