package com.example.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
//定制国际化功能区域解析器的配置类
public class MyLocalResovel implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l=httpServletRequest.getParameter("l");
        String header =httpServletRequest.getHeader("Accept-Language");
        Locale locale=null;
        if(!StringUtils.isEmpty(l)){
            String[] split =l.split("_");
            locale=new Locale(split[0],split[1]);
        }else {
            String[] splits=header.split(",");
            String[] split =splits[0].split("-");
            locale=new Locale(split[0],split[1]);
        }
        return locale;    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResovel();
    }
}
