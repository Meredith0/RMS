// package rms.demo.config.JWT;
//
// import java.io.IOException;
// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.web.filter.OncePerRequestFilter;
// import rms.demo.common.Const;
// import rms.demo.utils.JwtTokenUtil;
//
// /**
//  * @author : Meredith
//  * @date : 2019-05-27 00:08
//  * @description : Token验证的过滤器
//  */
//
// // We should use OncePerRequestFilter since we are doing a database call,
// // there is no point in doing this more than once
// public class JwtTokenFilter extends OncePerRequestFilter {
//
//     // 以前
//     // private JwtTokenProvider jwtTokenProvider;
//     //
//     // public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
//     //     this.jwtTokenProvider = jwtTokenProvider;
//     // }
//     //
//     // @Override
//     // protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//     //     FilterChain filterChain) throws ServletException, IOException {
//     //
//     //     String token = jwtTokenProvider.resolveToken(httpServletRequest);
//     //     try {
//     //         if (token != null && jwtTokenProvider.validateToken(token)) {
//     //             Authentication auth = jwtTokenProvider.getAuthentication(token);
//     //             SecurityContextHolder.getContext().setAuthentication(auth);
//     //         }
//     //     } catch (BaseException ex) {
//     //         //this is very important, since it guarantees the user is not authenticated at all
//     //         SecurityContextHolder.clearContext();
//     //         httpServletResponse.sendError(ex.getCode(), ex.getMessage());
//     //         return;
//     //     }
//     //
//     //     filterChain.doFilter(httpServletRequest, httpServletResponse);
//     // }
//
//     @Autowired
//     private UserDetailsService userDetailsService;
//
//     @Autowired
//     private JwtTokenUtil jwtTokenUtil;
//
//     @Override
//     protected void doFilterInternal (HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//
//         String authHeader = request.getHeader(Const.HEADER_STRING);
//         if (authHeader != null && authHeader.startsWith(Const.TOKEN_PREFIX)) {
//             final String authToken = authHeader.substring(Const.TOKEN_PREFIX.length());
//             String username = jwtTokenUtil.getUsernameFromToken(authToken);
//             if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                 UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//                 if (jwtTokenUtil.validateToken(authToken, userDetails)) {
//                     UsernamePasswordAuthenticationToken authentication =
//                         new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                     authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                     SecurityContextHolder.getContext().setAuthentication(authentication);
//                 }
//             }
//         }
//         chain.doFilter(request, response);
//     }
//
// }