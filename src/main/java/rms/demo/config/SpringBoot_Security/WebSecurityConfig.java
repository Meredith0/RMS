package rms.demo.config.SpringBoot_Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsUtils;
import rms.demo.config.JWT.JwtTokenFilterConfigurer;
import rms.demo.config.JWT.JwtTokenProvider;

/**
 * @author : Meredith
 * @date : 2019-05-09 21:30
 * @description : Spring Security 配置类
 */
@SpringBootConfiguration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    /**
     * 主配置类
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()//apply rms.demo.config.CorsConfig
            .csrf().disable()//允许普通请求跨域
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//禁用session
            .and()
            //允许访问以下路径
            .authorizeRequests()
            .antMatchers("/signin").permitAll()
            .antMatchers("/signup").permitAll()
            .requestMatchers(CorsUtils :: isPreFlightRequest).permitAll()
            .antMatchers(HttpMethod.OPTIONS).permitAll()//不拦截option请求
            //其他的都必须进过授权
            .anyRequest().authenticated();

        http.headers().cacheControl();// 禁用缓存

        http.exceptionHandling().accessDeniedPage("/error/access_deny");

        http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));// Apply JWT
    }

    /**
     * 允许访问静态资源
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // Allow swagger to be accessed without authentication
        web.ignoring().antMatchers("/v2/api-docs")//
            .antMatchers("/swagger-resources/**")//
            .antMatchers("/swagger-ui.html")//
            .antMatchers("/configuration/**")//
            .antMatchers("/webjars/**")//
            .antMatchers("/public")
            // Un-secure H2 Database (for testing purposes, H2 console shouldn't be unprotected in production)
            .and()
            .ignoring()
            .antMatchers("/h2-console/**/**");
    }

    /**
     * @return 重写这个方法, 加上@Bean  否则AuthenticationManager无法被注入
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}