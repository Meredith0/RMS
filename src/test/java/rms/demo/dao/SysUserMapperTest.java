package rms.demo.dao;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
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
       userMapper.listRoleById(1).forEach(System.out::println);
    }

    @Test
    void test03 () {
         var user = userMapper.findRoleByUserId("1");
        System.out.println(user);
    }
    @Test
    void test02 () {
        SysUser userAndRoleByUserId = userMapper.findUserAndRoleByUsername("张三");
    }
}