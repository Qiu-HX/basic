package com.pikaqiu.manage.biz.impl;

import com.pikaqiu.dal.mapper.SysUserMapper;
import com.pikaqiu.dal.model.SysUser;
import com.pikaqiu.fwk.common.Error;
import com.pikaqiu.fwk.exception.BusinessException;
import com.pikaqiu.manage.biz.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by user on 2017/8/8.
 */
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Transactional
    public void insertUser(SysUser sysUser) {
        System.out.println("----------insertUser beg-----------");
        sysUserMapper.insertSelective(sysUser);
        System.out.println("----------insertUser end-----------");
        /*if(true) {//手动抛异常，测试事务回滚
            System.out.println("----------insertUser Transactional Test-----------");
            throw new BusinessException(Error.TestException.TEST_EXP);
        }*/
        return;
    }

    public void updateUser(SysUser sysUser) {
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
        return;
    }

    public void deleteUser(int userId) {
        sysUserMapper.deleteByPrimaryKey(userId);
    }

    public void enableUser(int userId, boolean enable) {
        SysUser sysUser = new SysUser();
        sysUser.setEnable(enable);
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
        return;
    }

    public void resetPassword(String account, String oldPwd, String newPwd) {
        SysUser sysUser = new SysUser();
        sysUser.setPassword(newPwd);
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
        return;
    }

    public void resetPasswordDefault(int userId, String password) {

    }
}
