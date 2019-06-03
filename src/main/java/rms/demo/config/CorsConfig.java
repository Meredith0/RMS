package rms.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : Meredith
 * @date : 2019-06-03 23:31
 * @description : 允许OPTIONS请求跨域
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * Configure cross origin requests processing.
     *
     * @since 4.2
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//设置允许跨域请求的域名
            .allowedOrigins("*")//是否允许证书 不再默认开启
            .allowCredentials(true)//设置允许的方法
            .allowedMethods("*")//跨域允许时间
            .maxAge(3600);
    }
}

