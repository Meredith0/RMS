package rms.demo.service.SpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rms.demo.dao.SysUserMapper;
import rms.demo.domain.SysUser;

/**
 * @author : Meredith
 * @date : 2019-07-26 16:59
 * @description : 用户登陆
 */
@Service
public class UserService  implements UserDetailsService {

    @Autowired
    SysUserMapper userMapper;

    public static String username;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        SysUser user = userMapper.findUserAndRoleByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        username = user.getUsername();
        return user;
    }
}
