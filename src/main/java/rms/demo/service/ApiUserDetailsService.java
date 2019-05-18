package rms.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import rms.demo.dao.RoleMapper;
import rms.demo.dao.SysUserMapper;
import rms.demo.domain.Permission;
import rms.demo.domain.Role;
import rms.demo.domain.SysUser;

/**
 * @author : Meredith
 * @date : 2019-05-09 21:22
 * @description :
 */
@Component
public class ApiUserDetailsService implements UserDetailsService {

    @Autowired
    SysUserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public UserDetails loadUserByUsername(String username) {

        //获取用户信息和角色
        SysUser userAndRole = userMapper.findUserAndRoleByUsername(username);
        if (userAndRole == null) {
            return null;
        }
        //获取角色
        List<Role> roles = userAndRole.getRoles();
        //获取角色的role_id
        List<Integer> ids = roles.stream().map(Role::getRoleId).collect(Collectors.toList());

        //if (user.isPresent()) {
        List<Permission> permissions = roleMapper.findPermissionByRoleId(ids);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Permission permission : permissions) {
            if (permission != null && permission.getPermissionName() != null) {

                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getPermissionName());
                //此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                grantedAuthorities.add(grantedAuthority);
            }
        }
        return new SysUser(userAndRole.getUsername(), userAndRole.getPassword(), grantedAuthorities);
        // } else {
        //     throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        // }
    }
}