package rms.demo.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rms.demo.common.RespBean;
import rms.demo.domain.Employee;
import rms.demo.service.EmpService;

/**
 * @author : Meredith
 * @date : 2019-06-02 09:41
 * @description : 员工管理模块, 需要emp权限
 */
@RestController()
public class EmpCtrl {

    private static final int PAGE_COUNT = 20;//分页大小
    @Autowired
    EmpService empService;

    /**
     * 分页查询
     * @param page
     * @return
     */
    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public List<Employee> showEmp(@RequestParam int page) {
        int offset = (page-1) * PAGE_COUNT;
        return empService.getAllEmployeeLimited(offset, PAGE_COUNT);
    }

    @RequestMapping (value = "/total",method = RequestMethod.GET)
    public int totalEmp () {
        return empService.getTotalEmp();
    }

    /**
     * 新增员工 成功则返回204, 否则抛异常
     * @param empDetails 传入的员工信息
     * @throws Exception
     */
    @ResponseStatus(value = HttpStatus.NO_CONTENT)//204
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public void addEmp(@RequestBody Map<String,String> empDetails) throws Exception {
        String empName = empDetails.get("empName");
        String empAddress = empDetails.get("empAddress");
        String empDate = empDetails.get("empDate");
        if (empService.addEmp(empName, empAddress, empDate) != 1) {
            throw new Exception("insert failed");
        }
    }

    @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    public RespBean updateEmp(@RequestBody Map<String, String> empDetails) {
        String id = empDetails.get("id");
        String empName = empDetails.get("empName");
        String empAddress = empDetails.get("empAddress");
        String empDate = empDetails.get("empDate");

        int empId = Integer.valueOf(id);
        int i = empService.updateEmp(empId, empName, empAddress, empDate);
        if (i == 1) {
            return RespBean.builder().status(204).msg("update success").build();
        }
        else {
            return RespBean.builder().status(409).msg("conflict, update failed").build();
        }
    }

    @RequestMapping(value = "/emp",method = RequestMethod.DELETE)
    public RespBean deleteEmp(@RequestParam String empId) {
        int i = empService.deleteEmp(Integer.valueOf(empId));
        if (i == 1) {
            return RespBean.builder().status(204).msg("delete success").build();
        }
        else {
            return RespBean.builder().status(409).msg("conflict, delete failed").build();
        }
    }
}
