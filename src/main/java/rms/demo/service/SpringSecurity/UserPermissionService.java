package rms.demo.service.SpringSecurity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import rms.demo.dao.SysUserMapper;
import rms.demo.domain.Role;

/**
 * @author : Meredith
 * @date : 2019-07-26 10:04
 * @description :
 */
public class UserPermissionService {

    @Autowired
    SysUserMapper mapper;

    public List<Role> listByRoleId(Integer userId) {
        return mapper.listRoleById(userId);
    }
}
