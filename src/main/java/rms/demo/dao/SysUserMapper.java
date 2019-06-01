package rms.demo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;
import rms.demo.domain.SysUser;
import rms.demo.domain.SysUserExample;

@Mapper
public interface SysUserMapper {

    List<SysUser> findUserAndRoleByUsername(String username);

    SysUser findRoleById(int id);

    SysUser findRoleByUsername(String username);

    @Select("SELECT * FROM sys_user")
    List<SysUser> selectAll();

    boolean existByUsername(@Param("username") String username);

    SysUser find(String username);

    //generated code
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}