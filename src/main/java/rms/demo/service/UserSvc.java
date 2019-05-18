package rms.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rms.demo.dao.SysUserMapper;

/**
 * @author : Meredith
 * @date : 2019-05-06 20:41
 * @description :
 */
@Service
public class UserSvc implements UserDetailsService {

    @Autowired
    SysUserMapper userMapper;

    // /**
    //  * 登陆验证
    //  * @param username
    //  * @param password
    //  * @return
    //  */
    // public boolean loginVerify(String username, String password) {
    //     userMapper emp = userMapper.select(username, password);
    //     return emp != null;
    // }

    // public List<User> selectAll() {
    //     return userMapper.selectAll();
    // }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
