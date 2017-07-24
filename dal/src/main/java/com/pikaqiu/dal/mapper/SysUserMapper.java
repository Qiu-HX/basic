package com.pikaqiu.dal.mapper;

import com.basi.ebuy.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {


    int insert(SysUser record);

    SysUser getUserByName(@Param("username") String username);

    int update(SysUser record);

    List<SysUser> getUsers(@Param("searchKey") String searchKey);

    SysUser getUserById(@Param("userId") int userId);

    void deleteByUserId(@Param("userId") int userId);

    void enableUser(@Param("userId") int userId, @Param("enable") boolean enable);

    List<SysUser> getUserByRoleName(@Param("roleName") String roleName);
}