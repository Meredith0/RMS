package rms.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import rms.demo.domain.Permission;
import rms.demo.domain.entity.User;

@Mapper
@Repository
public interface UserDao extends tk.mybatis.mapper.common.Mapper<User> {

    @Select("SELECT permission.*\n"
        + "FROM user\n"
        + "         INNER JOIN user_role ON user.id = user_role.user_id\n"
        + "         INNER JOIN role_permission ON user_role.role_id = role_permission.role_id\n"
        + "         INNER JOIN permission ON role_permission.permission_id = permission.permission_id\n"
        + "WHERE user.username='张三'")
    public Permission findPermissionByUsername();

}
