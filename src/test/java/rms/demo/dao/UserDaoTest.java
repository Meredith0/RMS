package rms.demo.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
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

    @Test
    void testSelectPermissionByUsername() {
        Permission pms =userMapper.findPermissionByUsername();
        System.out.println(pms);
    }

    @Test
    void test01(){
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }
}