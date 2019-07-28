// package rms.demo.service;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.stereotype.Service;
// import rms.demo.config.JWT.JwtTokenProvider;
// import rms.demo.utils.CustomPasswordEncoder;
// import rms.demo.dao.SysUserMapper;
// import rms.demo.domain.SysUser;
// import rms.demo.exception.BaseException;
//
// /**
//  * @author : Meredith
//  * @date : 2019-05-06 20:41
//  * @description :
//  */
// @Service
// public class UserService {
//
//     public static String username;
//     @Autowired
//     SysUserMapper userMapper;
//
//     @Autowired
//     CustomPasswordEncoder customPasswordEncoder;
//
//     @Autowired
//     private JwtTokenProvider jwtTokenProvider;
//
//     @Autowired
//     private AuthenticationManager authenticationManager;
//
//     @Autowired
//     private CustomPasswordEncoder passwordEncoder;
//
//     public String signin(String userId, String password) throws BaseException {
//         try {
//             authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, password));
//             return jwtTokenProvider.createToken(userId, userMapper.findRoleByUserId(userId).getRoles());
//         } catch (AuthenticationException e) {
//             throw new BaseException(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Invalid username/password supplied");
//         }
//     }
//
//     public String signup(SysUser user) throws BaseException {
//         if (!userMapper.existByUsername(user.getUsername())) {
//             user.setPassword(passwordEncoder.encode(user.getPassword()));
//             userMapper.insert(user);
//             return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
//         } else {
//             throw new BaseException(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Username is already in use");
//         }
//     }
// }
