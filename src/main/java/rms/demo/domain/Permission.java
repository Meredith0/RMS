package rms.demo.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class Permission implements GrantedAuthority {
    private Integer permissionId;

    private String permissionName;

    private String permissionInfo;

    @Override
    public String getAuthority() {
        return permissionName;
    }
}