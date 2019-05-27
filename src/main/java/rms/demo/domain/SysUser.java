package rms.demo.domain;

import java.util.Collection;
import java.util.List;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class SysUser implements UserDetails {

    private Integer id;
    private String username;
    private String password;
    private List<Role> roles;
    private List<Permission> permissions;
    private Collection<? extends GrantedAuthority> authorities;

    public SysUser() {}

    public SysUser(
        String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // List<Role> roles = this.getRoles();
        // for (Role role : roles) {
        //     Authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        // }
         return authorities;
        // return roles.stream()
        //            .map(Role :: getRoleName)
        //            .map(SimpleGrantedAuthority :: new)
        //            .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
