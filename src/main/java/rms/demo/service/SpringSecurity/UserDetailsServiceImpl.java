// package rms.demo.service.SpringSecurity;
//
// import java.util.ArrayList;
// import java.util.List;
// import java.util.stream.Collectors;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.stereotype.Service;
// import rms.demo.dao.RoleMapper;
// import rms.demo.dao.SysUserMapper;
// import rms.demo.domain.Permission;
// import rms.demo.domain.Role;
// import rms.demo.domain.SysUser;
// import rms.demo.service.UserService;
//
// /**
//  * @author : Meredith
//  * @date : 2019-05-09 21:22
//  * @description :
//  */
// @Service
// public class UserDetailsServiceImpl implements UserDetailsService {
//
//     @Autowired
//     SysUserMapper userMapper;
//
//     @Autowired
//     RoleMapper roleMapper;
//
//     private Logger logger = LoggerFactory.getLogger(getClass());
//
//     public UserDetails loadUserByUsername(String userId) {
//
//         //获取用户信息和角色
//         List<SysUser> userAndRole = userMapper.findUserAndRoleByUserId(userId);
//         if (userAndRole == null) {
//             return null;
//         }
//         //获取角色
//         ArrayList<Role> roles = new ArrayList<>();
//         for (SysUser user : userAndRole) {
//             roles.add(user.getRoles().get(0));
//         }
//
//         // if (ids.get(0) == null) {
//         //     return null;
//         // }
//
//         //todo 验证permission
//
//         // List<Permission> permissions = roleMapper.listPermissionByRoleId(ids);
//         // List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//         // for (Permission permission : permissions) {
//         //     if (permission != null && permission.getPermissionName() != null) {
//         //         GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getPermissionName());
//         //         //此处将权限信息添加到 GrantedAuthority 对象中，在后面进行权限验证时会使用GrantedAuthority 对象。
//         //         grantedAuthorities.add(grantedAuthority);
//         //     }
//         // }
//         // return new SysUser(userAndRole.get(0).getUsername(), userAndRole.get(0).getPassword(), grantedAuthorities);
//
//
//         UserService.username=userAndRole.get(0).getUsername();
//         return new SysUser(userAndRole.get(0).getId(), userAndRole.get(0).getUsername(), roles);
//     }
// }