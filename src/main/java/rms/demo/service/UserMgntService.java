package rms.demo.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rms.demo.dao.OtherMapper;
import rms.demo.dao.RoleMapper;
import rms.demo.dao.SysUserMapper;
import rms.demo.domain.SysUser;

/**
 * @author : Meredith
 * @date : 2019-07-28 08:58
 * @description : 用户管理
 */
@Service
public class UserMgntService {

    @Autowired
    SysUserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    OtherMapper otherMapper;

    public List<Object> showUsers () {

        HashMap<String, String> map = new HashMap<>();
        map.put("admin", "管理员");
        map.put("employee", "员工");
        map.put("dept", "部门经理");
        var users = userMapper.listUserAndRole();
        List<Object> userVos = new ArrayList<>();
        for (SysUser user : users) {
            userVos.add(new UserVo(user.getId(), user.getUsername(), map.get(user.getRoles().get(0).getRole())));
        }
        return userVos;
    }

    @Transactional
    public int addUser (String username, String password, String role) {

        SysUser user = new SysUser();
        user.setUsername(username);
        user.setPassword(password);
        int effectLine = 0;
        userMapper.insertUserAndGetId(user);
        effectLine = otherMapper.insertUser_Role(user.getId().toString(), role);
        return effectLine;
    }

    @Transactional
    public int updateUser (String id, String username, String password, String role) {
        int effectLine = 0;
        SysUser user2Update = new SysUser();
        user2Update.setId(Integer.valueOf(id));
        user2Update.setUsername(username);
        user2Update.setPassword(password);
        effectLine = userMapper.updateByPrimaryKey(user2Update);
        effectLine += otherMapper.updateUser_Role(id, role);
        return effectLine;
    }

    public void deleteUser (String id) {
        userMapper.deleteByPrimaryKey(Integer.valueOf(id));
        otherMapper.deleteUser_RoleByUserid(id);
    }

    public List<Object> searchUsers (String username) {
        username = "%" + username + "%";
        HashMap<String, String> map = new HashMap<>();
        map.put("admin", "管理员");
        map.put("employee", "员工");
        map.put("dept", "部门经理");
        var users =   userMapper.searchByUsername(username);;
        List<Object> userVos = new ArrayList<>();
        for (SysUser user : users) {
            userVos.add(new UserVo(user.getId(), user.getUsername(), map.get(user.getRoles().get(0).getRole())));
        }
        return userVos;

    }

}

@Data
class UserVo {

    Integer userId;
    String username;
    String role;

    public UserVo (Integer userId, String username, String role) {
        this.userId = userId;
        this.username = username;
        this.role = role;
    }

}

