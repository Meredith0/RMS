// package rms.demo.config.SpringBoot_Security;
//
// import java.io.IOException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.web.AuthenticationEntryPoint;
//
// /**
//  * @author : Meredith
//  * @date : 2019-05-26 22:14
//  * @description : 对于未登录的用户 直接返回401 (Unauthorized)
//  */
// public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//     @Override
//     public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
//         // This is invoked when user tries to access a secured REST resource without supplying any credentials
//         // We should just send a 401 Unauthorized response because there is no 'login page' to redirect to
//         response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//     }
// }