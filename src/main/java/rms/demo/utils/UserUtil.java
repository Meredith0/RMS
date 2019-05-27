package rms.demo.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import rms.demo.domain.SysUser;

/**
 * @author : Meredith
 * @date : 2019-05-23 22:10
 * @description : 工具类  用以返回当前用户
 */
public class UserUtil {
    public static SysUser getCurrentUser() {
        return (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
