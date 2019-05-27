package rms.demo.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rms.demo.service.UserService;

/**
 * @author : Meredith
 * @date : 2019-05-06 20:55
 * @description :
 */
@RestController()
public class UserCtrl {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/signin",method =RequestMethod.POST)
    public String login(@RequestBody Map<String,String>userDetail) {
        String username = userDetail.get("username");
        String password = userDetail.get("password");

        return userService.signin(username, password);
    }


    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String Auth() {
        return "HELLO";
    }
}
