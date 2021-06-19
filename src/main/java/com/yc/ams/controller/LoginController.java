package com.yc.ams.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.yc.ams.db.pojo.SysUser;
import com.yc.ams.utils.ResultResponse;
import com.yc.ams.utils.ResultTypeEnum;
import com.yc.ams.utils.ShiroUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/api/v1")
public class LoginController extends BaseController{

    @Autowired
    private Producer producer;

    // 图片验证码
    @RequestMapping("/captcha.jpg")
    public void kaptcha(HttpServletResponse response) throws Exception {

        response.setHeader("Cache-Control", "no-store,no-cache");// 避免浏览器缓存
        response.setContentType("image/jpeg");

        String text = producer.createText();// 验证码
        BufferedImage image = producer.createImage(text);
        //保存session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "jpg", outputStream);// 图片输出
        outputStream.flush();// 清空缓冲区
    }


    @ResponseBody
    @RequestMapping("/user/login")
    public ResultResponse login(SysUser user, String authcode) throws Exception {
        // 验证码不正确
        if (!authcode.equalsIgnoreCase(ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY)))
            return ResultResponse.Build(ResultTypeEnum.fail, "验证码错误！");

        Subject subject = ShiroUtils.getSubject();

        try {
            // 暂不使用加盐加密 todo
            /*String password = new Md5Hash(
                    user.getUserPassword(),
                    user.getUserNumber(),
                    SystemVariable.MD5_HASH_ITERATIONS).toHex();*/

            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserNumber(), user.getUserPassword());

            //记住登录 TODO
            //  token.setRememberMe(true); 暂时不使用记住登录功能
            System.out.println(token);
            subject.login(token);
            System.out.println("subject"+subject);

        } catch (IncorrectCredentialsException i) {
            return ResultResponse.Build(ResultTypeEnum.fail, i.getMessage());
        } catch (LockedAccountException l) {
            return ResultResponse.Build(ResultTypeEnum.fail, l.getMessage());
        } catch (AuthenticationException a) {
            System.out.println("a"+a);
            return ResultResponse.Build(ResultTypeEnum.fail, "账户验证失败！");
        }

        return ResultResponse.Build(ResultTypeEnum.success, getUser());
    }

}
