package rms.demo.service.SpringSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import rms.demo.dao.UserDao;
import rms.demo.domain.entity.User;

/**
 * @author : Meredith
 * @date : 2019-05-09 21:31
 * @description :
 */
@Component
public class MyCustomUserService implements UserDetailsService {

    @Autowired
    private UserDao userMapper;

    /**
     * 登陆验证时，通过username获取用户的所有权限信息
     * 并返回UserDetails放到spring的全局缓存SecurityContextHolder中，以供授权器使用
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userDetail = new User();
        userDetail.setUsername(username);
        User user = userMapper.loadUserByUsername(username);
        System.out.println(user.getPassword());
        userDetail.setPassword(user.getPassword());
        return userDetail;
    }
}