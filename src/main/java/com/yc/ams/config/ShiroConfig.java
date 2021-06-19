package com.yc.ams.config;

import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * shrio 验证登录框架
 */
@Configuration
public class ShiroConfig {

    @Bean
    public SessionManager sessionManager(){

        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        // 设置session 过期时间 60*60*24*1000，时间以毫秒为单位
        sessionManager.setGlobalSessionTimeout(60*60*24*1000);
        // 扫描session线程，清除session超时会话
        sessionManager.setSessionValidationSchedulerEnabled(true);
        // 从cookie中获取session登录信息,重写url，加入JSession
        sessionManager.setSessionIdUrlRewritingEnabled(true);
        return sessionManager;
    }

    @Bean
    public SecurityManager securityManager(ShiroRealm shiroRealm,SessionManager sessionManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }
    // 过滤器
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        //过期
        shiroFilter.setLoginUrl("/login.html");
        //登录成功
        shiroFilter.setSuccessUrl("/login.html");
        //未授权时跳转页
        shiroFilter.setUnauthorizedUrl("/403.html");
        //排除静态资源
        Map<String,String> filterMap = new LinkedHashMap<String,String>();
        // 空过滤器，什么都不过滤，直接放行
        filterMap.put("/assets/**","anon"); // 静态资源
        // 首页页面

        filterMap.put("/login.html","anon");// 登录页
        filterMap.put("/api/v1/captcha.jpg","anon");// 验证码
        filterMap.put("/**","user");//记住我访问
        filterMap.put("/**","anon"); // 静态资源
        // end  首页页面

        //这个下面的页面必须经过验证才能被访问
        //filterMap.put("/**","authc");//所有都要认证

        shiroFilter.setFilterChainDefinitionMap(filterMap);

        return shiroFilter;
    }

    //生命周期
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }
    //代理
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        // 解决目标类继承代理
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor sourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        sourceAdvisor.setSecurityManager(securityManager);
        return sourceAdvisor;
    }
}
