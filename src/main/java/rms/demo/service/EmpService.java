package rms.demo.service;

import java.rmi.server.ExportException;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rms.demo.dao.EmployeeMapper;
import rms.demo.domain.Employee;
import rms.demo.domain.EmployeeExample;

/**
 * @author : Meredith
 * @date : 2019-06-02 09:39
 * @description :
 */
@Service
public class EmpService {

    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployeeLimited(int offset, int count) {
        return employeeMapper.selectLimited(offset,count);
    }

    public int getTotalEmp () {
        EmployeeExample example = new EmployeeExample();
        return employeeMapper.countByExample(example);
    }

    public int addEmp(String empName, String empAddress, String date){
        Date sqlDate = java.sql.Date.valueOf(date);
        Employee employee = Employee.builder().name(empName).address(empAddress).date(sqlDate).build();
        return employeeMapper.insert(employee);
    }

    public int updateEmp(Integer empId,String empName, String empAddress, String date) {

        Date sqlDate = java.sql.Date.valueOf(date);
        Employee employee = Employee.builder().id(empId).name(empName).address(empAddress).date(sqlDate).build();
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public int deleteEmp(int empId) {
       return employeeMapper.deleteByPrimaryKey(empId);
    }
}
