package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/index").permitAll() //放行/index请求
                .mvcMatchers("/login.html").permitAll() //放行/login.html请求
                .anyRequest().authenticated() //其它请求需要登录认证后才能访问
                .and()
                .formLogin() //默认form表单页面登录
                .loginPage("/login.html") //使用自定义登录页面登录页面登录
                .loginProcessingUrl("/doLogin") //使用自定义登录页面时需要重新指定url，对应login.html中的action路径
                .usernameParameter("uname") //重新指定用户名名称
                .passwordParameter("pwd") //重新指定密码名称
                .successForwardUrl("/logout") //认证成功后跳转路径
                //forward 跳转路径  始终在认证成功之后跳转到指定请求 地址栏不变
                //.defaultSuccessUrl("/hello") //默认认证成功后跳转路径
                //.defaultSuccessUrl("/hello",true) //第二个参数设置为true时总是跳转，效果同successForwardUrl一致，默认false
                //redirect 重定向  注意:如果之前有请求过的路径,会优先跳转之前的请求路径 地址栏改变
                .failureUrl("/login.html") //登录失败后跳转路径
                .and()
                .logout()
                //.logoutUrl("/logout")//指定注销登录URL，默认请求方式必须为GET
                .logoutRequestMatcher(new OrRequestMatcher(
                        new AntPathRequestMatcher("/aaa", "GET"),
                        new AntPathRequestMatcher("/bbb", "POST")
                ))
                .and()
                .csrf().disable();//此处先关闭CSRF跨站保护
        }
}



