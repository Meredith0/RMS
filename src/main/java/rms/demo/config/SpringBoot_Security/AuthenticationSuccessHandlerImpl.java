// package rms.demo.config.SpringBoot_Security;
//
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
// import org.springframework.stereotype.Component;
//
// /**
//  * @author : Meredith
//  * @date : 2019-05-09 21:38
//  * @description :
//  */
// @Component
// public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
//     @Override
//     public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
//         // We do not need to do anything extra on REST authentication success, because there is no page to redirect to
//     }
//
//     // @Override
//     // public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse resp, Authentication authentication) throws IOException {
//     //     // 允许跨域
//     //     resp.setHeader("Access-Control-Allow-Origin", "*");
//     //     // 允许自定义请求头token(允许head跨域)
//     //     resp.setHeader("Access-Control-Allow-Headers", "token, Accept, Origin, X-Requested-With, Content-Type, Last-Modified");
//     //     try {
//     //         resp.getWriter().write("success");
//     //     } catch (IOException e) {
//     //         e.printStackTrace();
//     //     }
//     //
//     //     //设置RespBean
//     //     resp.setContentType("application/json;charset=utf-8");
//     //     RespBean respBean = RespBean.ok("success", UserUtil.getCurrentUser());
//     //     ObjectMapper om = new ObjectMapper();
//     //     PrintWriter out = resp.getWriter();
//     //     out.write(om.writeValueAsString(respBean));
//     //     out.flush();
//     //     out.close();
//     // }
// }
