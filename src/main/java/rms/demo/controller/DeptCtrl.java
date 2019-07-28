package rms.demo.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Meredith
 * @date : 2019-07-26 23:20
 * @description : 部门管理模块, 需要HR权限
 */
@RestController
@RequestMapping ("/dept")
@PreAuthorize ("hasAnyAuthority('admin','dept')")
public class DeptCtrl {

    @RequestMapping (value = "/hello", method = RequestMethod.GET)
    public String authTest() {
        return "hello from dept management";
    }
}
