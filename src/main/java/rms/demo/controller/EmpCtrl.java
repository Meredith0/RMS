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
import rms.demo.bean.RespBean;
import rms.demo.domain.Employee;
import rms.demo.service.EmpService;

/**
 * @author : Meredith
 * @date : 2019-06-02 09:41
 * @description :
 */
@RestController()
public class EmpCtrl {

    @Autowired
    EmpService empService;

    @RequestMapping(name = "/emp", method = RequestMethod.GET)
    public List<Employee> showEmp() {
        return empService.getAllEmployee();
    }

    /**
     * 新增员工 成功则返回204, 否则抛异常
     * @param empDetails 传入的员工信息
     * @throws Exception
     */
    @ResponseStatus(value = HttpStatus.NO_CONTENT)//204
    @RequestMapping(name = "/emp", method = RequestMethod.POST)
    public void addEmp(@RequestBody Map<String,String> empDetails) throws Exception {
        String empName = empDetails.get("empName");
        String empAddress = empDetails.get("empAddress");
        String empDate = empDetails.get("empDate");
        if (empService.addEmp(empName, empAddress, empDate) != 1) {
            throw new Exception("insert failed");
        }
    }

    @RequestMapping(name = "/emp",method = RequestMethod.PUT)
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

    @RequestMapping(name = "/emp",method = RequestMethod.DELETE)
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
