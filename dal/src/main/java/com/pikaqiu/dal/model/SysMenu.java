package com.pikaqiu.dal.model;

import java.util.List;

/**
 * 运维管理菜单
 */
public class SysMenu {

    /* 菜单ID */
    private Integer menuId;

    /* 父菜单ID */
    private Integer pid;

    /* 菜单名称 */
    private String menuName;

    /* 菜单图标 */
    private String menuImg;

    /* 链接url */
    private String linkUrl;

    /* 优先级 */
    private Integer priority;

    /* 权限关键值,访问该路径所需要的权限 */
    private String permission;

    /* 是否已删除 */
    private Boolean isDelete;

    private List<SysMenu> children;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuImg() {
        return menuImg;
    }

    public void setMenuImg(String menuImg) {
        this.menuImg = menuImg == null ? null : menuImg.trim();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public List<SysMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenu> children) {
        this.children = children;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}