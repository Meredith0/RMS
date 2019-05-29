package rms.demo.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rms.demo.bean.RespBean;
import rms.demo.service.UserService;
import rms.demo.utils.UserUtil;

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
    public Map<String,String> login(@RequestBody Map<String,String>userDetail) {
        Map<String, String> map = new HashMap<>();
        String username = userDetail.get("username");
        String password = userDetail.get("password");
        String token= userService.signin(username, password);
        map.put("token", token);
        map.put("username", username);
        return map;
    }


    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String Auth() {
        return "HELLO";
    }
}
