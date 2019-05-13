package rms.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.TypeDiscriminator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import rms.demo.domain.Permission;
import rms.demo.domain.entity.User;

@Mapper
@Repository
public interface UserDao{

    @Select("SELECT permission.*\n"
        + "FROM sys_user\n"
        + "         INNER JOIN user_role ON sys_user.id = user_role.user_id\n"
        + "         INNER JOIN role_permission ON user_role.role_id = role_permission.role_id\n"
        + "         INNER JOIN permission ON role_permission.permission_id = permission.permission_id\n"
        + "WHERE sys_user.username='#{username}'")
    Permission findPermissionByUsername(String username);

    /**
     * 通过username查找用户拥有的角色
     */
    @Select("SELECT sys_user.username,sys_user.password, role.role_name\n"
        + "FROM sys_user\n"
        + "         INNER JOIN user_role ON sys_user.id = role_id\n"
        + "         INNER JOIN role ON role.role_id = user_role.role_id\n"
        + "WHERE sys_user.username = '#{username}'")
    @Results(


    )
    User findRoleByUsername(String username);



    @Results({@Result(property = "username", column = "username"),
        @Result(property = "password", column = "password")
    })
    @Select("SELECT username,password FROM sys_user WHERE username=#{username}")
    User loadUserByUsername(String username);
}
