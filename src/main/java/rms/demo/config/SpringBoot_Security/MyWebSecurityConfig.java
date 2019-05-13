package rms.demo.config.SpringBoot_Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import rms.demo.service.SpringSecurity.MyCustomUserService;
import org.apache.logging.log4j.*;
/**
 * @author : Meredith
 * @date : 2019-05-09 21:30
 * @description :
 */
@SpringBootConfiguration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailHandler myAuthenticationFailHandler;

    @Bean
    UserDetailsService customUserService() {
        return new MyCustomUserService();
    }

    @Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义UserDetailsService
        auth.userDetailsService(customUserService()).passwordEncoder(new MyPasswordEncoder());;
    }

    /**
     * 登陆的路径是/login
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //登陆的路径
        http.formLogin().loginProcessingUrl("/login")
            //自定义的登录验证成功或失败后的去向
            .successHandler(myAuthenticationSuccessHandler).failureHandler(myAuthenticationFailHandler)
            // 禁用csrf防御机制(跨域请求伪造)，这么做在测试和开发会比较方便。
            .and().csrf().disable();
    }
}