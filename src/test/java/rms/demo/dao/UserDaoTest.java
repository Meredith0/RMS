package rms.demo.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rms.demo.domain.Permission;
import rms.demo.domain.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserDaoTest {

    @Autowired
    UserDao userMapper;

    // @Test
    // void testSelectPermissionByUsername() {
    //     Permission pms =userMapper.findPermissionByUsername();
    //     System.out.println(pms);
    // }

    @Test
    void test01(){
        User user = userMapper.loadUserByUsername("admin");
        System.out.println(user);
    }

    @Test
    void test02(){
        User user=userMapper.findRoleByUsername("admin");
        System.out.println(user);
    }

}