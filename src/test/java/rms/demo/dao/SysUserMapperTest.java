package rms.demo.dao;

import io.lettuce.core.output.ScanOutput;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rms.demo.domain.Permission;
import rms.demo.domain.Role;
import rms.demo.domain.SysUser;
import rms.demo.domain.SysUserExample;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("rms.demo.dao")
class SysUserMapperTest {

    @Autowired
    SysUserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Test
    void selectByExample() {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andIdEqualTo(1);

        List<SysUser> sysUsers = userMapper.selectByExample(example);
        System.out.println(sysUsers);

    }

    @Test
    void test01(){
       SysUser user = userMapper.findUserAndRoleByUsername("张三");
        //System.out.println(user.get(0)+"   "+user.get(1));
        System.out.println(user.toString());
    }

    @Test
    void test02(){
        SysUser user = userMapper.findRoleById(1);
        System.out.println(user);
    }

    @Test
    void test03(){
        SysUser userAndRole = userMapper.findUserAndRoleByUsername("张三");

        //获取角色
        List<Role> roles = userAndRole.getRoles();

        System.out.println(roles);
        //获取角色的role_id
        List<Integer> ids = roles.stream().map(Role::getRoleId).collect(Collectors.toList());

        //if (user.isPresent()) {
        List<Permission> permissions = roleMapper.findPermissionByRoleId(ids);

        permissions.forEach(System.out::println);
    }
}