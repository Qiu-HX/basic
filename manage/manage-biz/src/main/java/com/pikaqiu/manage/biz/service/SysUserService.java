package com.pikaqiu.manage.biz.service;

import com.pikaqiu.dal.model.SysUser;

/**
 * Created by jsg on 2017/4/12.
 */
public interface SysUserService {
    /**
     * 新增用户
     * @param sysUser
     */
    void insertUser(SysUser sysUser);

    /**
     * 更新用户
     * @param sysUser
     */
    void updateUser(SysUser sysUser);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(int userId);

    /**
     * 禁用或启用 用户
     * 禁用后不可登录
     * @param userId
     * @param enable
     */
    void enableUser(int userId, boolean enable);

    /**
     * 重置密码
     *
     * @param account
     * @param oldPwd
     * @param newPwd
     * @return
     */
    void resetPassword(String account, String oldPwd, String newPwd);

    /**
     * 重置密码，默认123456
     * @param userId
     * @param password
     */
    void resetPasswordDefault(int userId, String password);
}
