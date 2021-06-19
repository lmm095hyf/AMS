package com.yc.ams.utils;

import com.yc.ams.db.pojo.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Created by 林木木
 * Date :2021
 * Description : ShiroUtils
 * Version :1.0
 */
public class ShiroUtils {

    // 获取session
    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    // 获取用户
    public static SysUser getUserEntity(){
        return (SysUser)SecurityUtils.getSubject().getPrincipal();
    }

    // 获取用户id
    public static Integer getUserId(){
        return getUserEntity().getId();
    }

    // 设置session
    public static void setSessionAttribute(Object key,Object value){
        getSession().setAttribute(key,value);
    }

    // 根据key获取session-value
    public static Object getSessionAttribute(Object key){
       return getSession().getAttribute(key);
    }

    // 是否登录成功
    public static Boolean isLogin(){
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    // 登出
    public static void logout(){
        SecurityUtils.getSubject().logout();
    }

    // 获取验证码
    public static String getKaptcha(String key) throws Exception{
        Object kaptcha = getSessionAttribute(key);
        if (kaptcha == null){
            throw new Exception("验证码已失效！");
        }
        getSession().removeAttribute(key);
        return kaptcha.toString();
    }

}
