package rms.demo.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rms.demo.domain.SysUser;
import rms.demo.service.SpringSecurity.AuthService;
import rms.demo.service.SpringSecurity.UserService;

/**
 * @author : Meredith
 * @date : 2019-05-06 20:55
 * @description : 用户登陆
 */
@RestController ()
public class UserCtrl {

    @Autowired
    UserService userService;
    @Autowired
    private AuthService authService;

    @RequestMapping (value = "/hello", method = RequestMethod.GET)
    public String Auth (String param) {
        System.out.println(param);
        return "HELLO "+param;
    }

    // 登录
    @RequestMapping (value = "/authentication/login", method = RequestMethod.POST)
    public Map<String,String> createToken (String username, String password) throws AuthenticationException {
         Map<String, String> map = new HashMap<>();
        // String userId = userDetail.get("username");
        // String password = userDetail.get("password");

        String token = authService.login(username, password);
        map.put("token", token);
        map.put("username", UserService.username);
        map.put("auth", UserService.auth);
        return map;
    }

    // 注册
    @RequestMapping (value = "/authentication/register", method = RequestMethod.POST)
    public SysUser register (@RequestBody SysUser addedUser) throws AuthenticationException {
        return authService.register(addedUser);
    }



}
