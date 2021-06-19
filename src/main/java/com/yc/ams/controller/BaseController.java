package com.yc.ams.controller;


import com.yc.ams.db.pojo.SysUser;
import com.yc.ams.utils.ShiroUtils;

public abstract class BaseController {

    //获取用户
    protected SysUser getUser(){
        return ShiroUtils.getUserEntity();
    }
    protected Integer getUserId(){
        return getUser().getId();
    }
}
