package rms.demo.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author : Meredith
 * @date : 2019-05-06 20:25
 * @description : 用户的实体类
 */
@Data
@Table(name = "user")
public class User implements UserDetails {

    @Id
    private Integer id;
    private String username;
    private String password;

    private List<GrantedAuthority> authorities = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
