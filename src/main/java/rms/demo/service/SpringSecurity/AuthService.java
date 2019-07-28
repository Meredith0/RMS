package rms.demo.service.SpringSecurity;
import rms.demo.domain.SysUser;

/**
 * @author : Meredith
 * @date : 2019-07-26 16:54
 * @description :
 */

public interface AuthService {
    SysUser register(SysUser userToAdd );
    String login( String username, String password );
}
