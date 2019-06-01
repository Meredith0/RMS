package rms.demo.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Meredith
 * @date: 2019-04-11 19:56
 * @project: UserLogin
 * @package: demo.config
 * @description: 过滤器, 配置放行header
 */
@Configuration
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chain)
        throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) sresponse;
        HttpServletRequest request = (HttpServletRequest) srequest;
        response.setContentType("textml;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response
            .setHeader("Access-Control-Allow-Credentials", "true"); //是否允许浏览器携带用户身份信息（cookie）
        response.addHeader("Access-Control-Allow-Headers",
            "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");

        chain.doFilter(srequest, sresponse);
    }
}
