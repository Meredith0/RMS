package rms.demo.config.SpringSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author : Meredith
 * @date : 2019-05-09 21:17
 * @description :
 */
@Configuration
@EnableResourceServer
public class SsbResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler ssbAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler ssbAuthenticationFailureHandler;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 所以在我们的app登录的时候我们只要提交的action，不要跳转到登录页
        http.formLogin()
            //登录页面，app用不到
            //.loginPage("/authentication/login")
            //登录提交action，app会用到
            // 用户名登录地址
            .loginProcessingUrl("/form/token")
            //成功处理器 返回Token
            .successHandler(ssbAuthenticationSuccessHandler)
            //失败处理器
            .failureHandler(ssbAuthenticationFailureHandler);

        http
            // 手机验证码登录
            .apply(smsCodeAuthenticationSecurityConfig)
            .and()
            .authorizeRequests()
            //手机验证码登录地址
            .antMatchers("/mobile/token", "/email/token")
            .permitAll()
            .and()
            .authorizeRequests()
            .antMatchers(
                "/register",
                "/social/**",
                "/**/*.js",
                "/**/*.css",
                "/**/*.jpg",
                "/**/*.png",
                "/**/*.woff2",
                "/code/image")
            .permitAll()//以上的请求都不需要认证
            .anyRequest()
            .authenticated()
            .and()
            .csrf().disable();
    }
}
