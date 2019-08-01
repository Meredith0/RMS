package rms.demo.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rms.demo.domain.Employee;
import rms.demo.domain.MsgEs;
import rms.demo.service.EmpService;

/**
 * @author : Meredith
 * @date : 2019-07-31 16:45
 * @description : 员工管理
 */
@RestController
@RequestMapping ("/emp")
@PreAuthorize ("hasAnyAuthority('admin','dept')")
public class EmpCtrl {

    @Autowired
    private EmpService empService;

    /**
     * 列出所有员工信息，不分页
     */
    @RequestMapping ("/listEmps")
    @ResponseBody
    public MsgEs doListEmp () {
        List<Employee> list = empService.findEmpAll();
        return MsgEs.success().add("emps", list);
    }

    @RequestMapping ("show")
    public Map<String,Object> show (@RequestParam (defaultValue = "1") int pageNo,
                                @RequestParam (defaultValue = "5") int pageSize) {
      PageHelper.startPage(pageNo, pageSize);
        List<Employee> emps = empService.show();
        int total = ((Page) emps).getPages();
        HashMap<String, Object> map = new HashMap<>();
        map.put("emp",emps);
        map.put("total", total);
        return map;
    }

    @RequestMapping(value = "/thisEmp",method = RequestMethod.GET)
    public Employee emp (Integer eid) {
        return empService.thisEmp(eid);

    }
    @ResponseStatus (value = HttpStatus.NO_CONTENT)//204
    @RequestMapping (value = "emp", method = RequestMethod.POST)
    public void addEmp (Employee emp) throws Exception {
        if (empService.addEmp(emp) != 1) {
            throw new Exception("add emp failed");
        }
    }
    @ResponseStatus (value = HttpStatus.NO_CONTENT)//204
    @RequestMapping (value = "emp", method = RequestMethod.PUT)
    public void updateEmp (Employee emp) throws Exception {
        if (empService.updateEmp(emp) != 1) {
            throw new Exception("update emp failed");
        }
    }

    @ResponseStatus (value = HttpStatus.NO_CONTENT)//204
    @RequestMapping (value = "emp", method = RequestMethod.DELETE)
    public void deleteEmp (int eid) throws Exception {
        if (empService.deleteEmp(eid) != 1) {
            throw new Exception("delete emp failed");
        }
    }

    @RequestMapping ("find")
    public Map<String, Object> find (@RequestParam (defaultValue = "1") int pageNo,
                                     @RequestParam (defaultValue = "5") int pageSize, String name) {

        long total = PageHelper.startPage(pageNo, pageSize).getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("emp", empService.find(name));
        map.put("totalPage", total);
        return map;
    }

}
