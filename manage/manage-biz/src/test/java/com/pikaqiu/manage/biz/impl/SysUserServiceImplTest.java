package com.pikaqiu.manage.biz.impl;

import com.pikaqiu.dal.model.SysUser;
import com.pikaqiu.manage.biz.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by user on 2017/8/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:manage-biz-config-test.xml"})
//事务关联到配置文件中的事务控制器（transactionManager），同时指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！
@TransactionConfiguration(transactionManager = "transactionManager")
@ActiveProfiles("test")
public class SysUserServiceImplTest {
    @Autowired
    private SysUserService sysUserService;

    @Test
    @Transactional
    public void insertUser() throws Exception {
        SysUser sysUser = new SysUser();
        sysUser.setNickname("admin");
        sysUser.setUsername("admin");
        sysUser.setPhone("15659798851");
        sysUser.setPassword("123456");
        sysUser.setEnable(true);
        sysUser.setCreateTime(new Date());
        sysUser.setCreateBy("JUnit4");
        sysUserService.insertUser(sysUser);
    }

    @Test
    public void updateUser() throws Exception {

    }

    @Test
    public void deleteUser() throws Exception {

    }

    @Test
    public void enableUser() throws Exception {

    }

    @Test
    public void resetPassword() throws Exception {

    }

    @Test
    public void resetPasswordDefault() throws Exception {

    }

}