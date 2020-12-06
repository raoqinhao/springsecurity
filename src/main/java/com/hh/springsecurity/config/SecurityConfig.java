package com.hh.springsecurity.config;

import com.hh.springsecurity.pojo.UserBean;
import com.hh.springsecurity.strategy.LzcExpiredSessionStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;


    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/toLogin")
                .loginProcessingUrl("/toLogin")
//                下面两种跳转到主页面的时候转发到主页接口中，地址栏不发生改变
//                .defaultSuccessUrl("/toIndex")
//                .successForwardUrl("/toIndex")
                // 表示登录成功后指定重定向到某个指定的接口中，例：toIndex
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletResponse.setContentType("application/json;charset=utf=8");
                    httpServletResponse.sendRedirect("toIndex");
                })
                .permitAll()
                .and()
                .logout()
                // 默认登出功能只是跳转页面，并未将用户的sessionid删除。
//                .logoutUrl("/toLogout")
//                .logoutSuccessUrl("/toLogout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler())
                .permitAll()
                .and()
                .sessionManagement()
                .maximumSessions(3)
                .maxSessionsPreventsLogin(false)
                // 添加session过期策略
                .expiredSessionStrategy(new LzcExpiredSessionStrategy());
        http.authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/fonts/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/layui/**").permitAll()
                .antMatchers("/less/**").permitAll()
                .antMatchers("/lib/**").permitAll()
                .antMatchers("/sass/**").permitAll()
                .antMatchers("/dist/**").permitAll()
                .antMatchers("/alibabafonts/**").permitAll()
                .antMatchers("/public_img/**").permitAll()
                .antMatchers("/templates/**").permitAll()
                .antMatchers("/toRegisterPage").permitAll()
                .antMatchers("/toRegister").permitAll()
                .antMatchers("/findAllUser").hasRole("admin")
                .antMatchers("admin").permitAll()
                .anyRequest().authenticated();
        //关闭html中的iframe拦截功能
        http.headers().frameOptions().disable();
        // 跨站点请求伪造功能关闭
        http.csrf().disable();
    }


    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() { //登出处理
        return new LogoutSuccessHandler() {
            @Override
            public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                try {
                    User userBean = (User) authentication.getPrincipal();
                    logger.info("USER : " + userBean.getUsername() + " LOGOUT SUCCESS !  ");
                } catch (Exception e) {
                    logger.info("LOGOUT EXCEPTION , e : " + e.getMessage());
                }
                httpServletResponse.sendRedirect("/toLogin");
            }
        };
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }
}
