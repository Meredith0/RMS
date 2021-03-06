package rms.demo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.demo.domain.Permission;
import rms.demo.domain.Role;
import rms.demo.domain.RoleExample;

public interface RoleMapper {

    List<Permission> listPermissionByRoleId (Integer id);

    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    Integer insertRoleAndGetId (String role);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);
}