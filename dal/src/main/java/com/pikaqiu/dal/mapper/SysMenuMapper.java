package com.pikaqiu.dal.mapper;

import com.basi.ebuy.model.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuMapper {

    int delete(Integer menuId);

    int insert(SysMenu record);

    SysMenu getMenuById(Integer menuId);

    int update(SysMenu record);

    /**
     * 获取运维管理菜单列表
     *
     * @return
     */
    List<SysMenu> getMenuList();

    /*根据菜单ID列表查找菜单*/
    List<SysMenu> getMenuByIds(@Param("resourceIds") List<Integer> resourceIds);

    List<String> getMenuPermissionByIds(@Param("resourceIds") List<Integer> resourceIds);

    List<String> getAllPermission();

    List<String> getRoleResourceNameByRoleId(@Param("roleId") int roleId);

}