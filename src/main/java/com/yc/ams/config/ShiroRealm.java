package com.yc.ams.config;


import com.yc.ams.db.pojo.SysUser;
import com.yc.ams.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * shrio 框架  实现登录验证
 */
@Component
public class ShiroRealm extends AuthorizingRealm  {

    @Autowired
    private UserService userService;

    //  认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 获取用户名
        String loginName = (String) token.getPrincipal();
        // 获取密码
        String loginPassword = new String((char[]) token.getCredentials());
        SysUser user = userService.selectUserPasswordByName(loginName);

        System.out.println("loginName:"+loginName);
        System.out.println("loginName:"+loginPassword);

        if (user == null){
            throw new UnknownAccountException("账号或密码不正确！");
        }
        // 判断密码是否正确
        if (!loginPassword.equals(user.getUserPassword())){
            throw new IncorrectCredentialsException("账号或密码不正确！");
        }
        // 用户锁定，软删除
//        if (user.getUserIsdel() == "0")
//            throw new LockedAccountException("用户被锁定，请联系管理员！");

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                user,
                user.getUserPassword(),
                this.getName());

        return info;
    }

    //  授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
