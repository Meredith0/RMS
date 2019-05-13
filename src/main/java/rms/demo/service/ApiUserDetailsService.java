package rms.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author : Meredith
 * @date : 2019-05-09 21:22
 * @description :
 */
@Component
public class ApiUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    // /*
    //  * (non-Javadoc)
    //  *
    //  * @see org.springframework.security.core.userdetails.UserDetailsService#
    //  * loadUserByUsername(java.lang.String)
    //  */
    // // 这里的username 可以是username、mobile、email
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     logger.info("表单登录用户名:" + username);
    //     return buildUser(username);
    // }
    //
    // private SocialUser buildUser(String userId) {
    //     // 根据用户名查找用户信息
    //     //根据查找到的用户信息判断用户是否被冻结
    //     String password = passwordEncoder.encode("123456");
    //     logger.info("数据库密码是:" + password);
    //     return new SocialUser(userId, password,
    //         true, true, true, true,
    //         AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));
    // }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}