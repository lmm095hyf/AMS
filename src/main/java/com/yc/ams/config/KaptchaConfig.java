package com.yc.ams.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * kaptcha  验证码生成工具
 */
@Configuration
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha defaultKaptcha(){

        Properties properties = new Properties();

        properties.put("kaptcha.border","no");//无边框
        properties.put("kaptcha.textproducer.font.color","black");//字体颜色
        properties.put("kaptcha.textproducer.char.space","4");// 五个字符
        properties.put("kaptcha.textproducer.char.length","4");//字体颜色
        properties.put("kaptcha.image.width","120");// 五个字符
        properties.put("kaptcha.image.height","40");// 五个字符
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);

        return defaultKaptcha;
    }
}
