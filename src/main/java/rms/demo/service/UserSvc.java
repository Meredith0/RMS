package rms.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rms.demo.dao.UserDao;
import rms.demo.domain.entity.User;

/**
 * @author : Meredith
 * @date : 2019-05-06 20:41
 * @description :
 */
@Service
public class UserSvc {

    @Autowired
    UserDao userMapper;

    // /**
    //  * 登陆验证
    //  * @param username
    //  * @param password
    //  * @return
    //  */
    // public boolean loginVerify(String username, String password) {
    //     userMapper emp = userMapper.select(username, password);
    //     return emp != null;
    // }

    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
