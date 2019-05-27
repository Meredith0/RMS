package rms.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import rms.demo.config.JWT.JwtTokenProvider;
import rms.demo.config.SpringBoot_Security.CustomPasswordEncoder;
import rms.demo.dao.SysUserMapper;
import rms.demo.domain.SysUser;
import rms.demo.exception.CustomException;

/**
 * @author : Meredith
 * @date : 2019-05-06 20:41
 * @description :
 */
@Service
public class UserService {

    @Autowired
        SysUserMapper userMapper;

        @Autowired
        CustomPasswordEncoder customPasswordEncoder;

        @Autowired
        private JwtTokenProvider jwtTokenProvider;

        @Autowired
        private AuthenticationManager authenticationManager;

    @Autowired
    private CustomPasswordEncoder passwordEncoder;

        public String signin(String username, String password) {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
                return jwtTokenProvider.createToken(username, userMapper.findRoleByUsername(username).getRoles());
            } catch (AuthenticationException e) {
                throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }

        public String signup(SysUser user) {
            if (!userMapper.existByUsername(user.getUsername())) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                userMapper.insert(user);
                return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
            } else {
                throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }


}
