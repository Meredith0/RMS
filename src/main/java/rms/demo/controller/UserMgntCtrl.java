package rms.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rms.demo.service.UserMgntService;

/**
 * @author : Meredith
 * @date : 2019-07-26 14:49
 * @description : 用户管理模块, 需要admin权限
 */
@RestController
@RequestMapping ("/user")
@PreAuthorize ("hasAuthority('admin')")
public class UserMgntCtrl {

    @Autowired
    UserMgntService service;

    @RequestMapping (value = "/hello", method = RequestMethod.GET)
    public String authTest() {
        return "hello from user management";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public List<Object> showUsers () {
        return service.showUsers();
    }

    //新增用户
    @ResponseStatus (value = HttpStatus.NO_CONTENT)//204
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void addUser(String username, String password, String role) throws Exception {

        if (service.addUser(username, password, role) != 1) {
            throw new Exception("insert user failed");
        }
    }

    //修改用户
    @ResponseStatus (value = HttpStatus.NO_CONTENT)//204
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public void updateUser(String id,String username, String password, String role) throws Exception {

        if (service.updateUser(id,username, password, role) != 2) {
            throw new Exception("update user failed");
        }
    }

    //删除用户
    @ResponseStatus (value = HttpStatus.NO_CONTENT)//204
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public void deleteUser(String id) throws Exception {

        service.deleteUser(id);
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Object> searchUsers (String username) {
        return service.searchUsers(username);
    }

}

