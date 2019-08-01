package rms.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rms.demo.dao.DepartmentMapper;
import rms.demo.dao.EmpMapper;
import rms.demo.dao.PositionMapper;
import rms.demo.domain.Employee;
import rms.demo.exception.BaseException;

/**
 * @author : Meredith
 * @date : 2019-07-31 16:52
 * @description :
 */
@Service
public class EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DepartmentMapper deptMapper;

    @Autowired
    private PositionMapper positionMapper;

    public List<Employee> findEmpAll () {
        List<Employee> employees = empMapper.selectEmpAll();
        return employees;
    }

    public List<Employee> show () {
        return empMapper.listAllEmp();
    }

    public int addEmp (Employee emp) throws BaseException {
        validateInput(emp);
       return empMapper.addEmp(emp);
    }

    public int updateEmp (Employee emp) throws BaseException {
         validateInput(emp);
        return empMapper.updateEmp(emp);
    }

    public int deleteEmp (int eid)  {

        return empMapper.deleteEmp(eid);
    }

    public List<Employee> find (String name) {
       return empMapper.find("%"+name+"%");
    }

    private void validateInput (Employee emp) throws BaseException {
        int i = deptMapper.validateDeptId(emp.getDid());
        int j = positionMapper.validatePid(emp.getPid());
        if (i == 0 || j == 0) {
            throw new BaseException(500, "pid or did not exist");
        }
    }

    public Employee thisEmp (Integer eid) {
       return empMapper.getEmpById(eid);
    }

}
