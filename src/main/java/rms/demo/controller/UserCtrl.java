package rms.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import rms.demo.service.UserSvc;

/**
 * @author : Meredith
 * @date : 2019-05-06 20:55
 * @description :
 */
@Controller
public class UserCtrl {

    @Autowired
    UserSvc empSvc;

    // /**
    //  * 登陆请求转发
    //  * @param username
    //  * @param password
    //  * @return 是否验证通过
    //  */
    // @RequestMapping(value = "/login", method = RequestMethod.POST)
    // public boolean loginVerify(@RequestParam(value = "username") String username,
    //     @RequestParam(value = "password") String password) {
    //     return empSvc.loginVerify(username, password);
    // }
}
