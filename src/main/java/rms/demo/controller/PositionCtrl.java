package rms.demo.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Meredith
 * @date : 2019-07-26 23:21
 * @description : 职位管理模块 需要dept权限
 */
@RestController
@RequestMapping ("/position")
@PreAuthorize ("hasAnyAuthority('admin','dept')")
public class PositionCtrl {


}
