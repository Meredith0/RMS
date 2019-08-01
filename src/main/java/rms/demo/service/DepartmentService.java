package rms.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rms.demo.dao.DepartmentMapper;
import rms.demo.domain.Department;

/**
 * @author : Meredith
 * @date : 2019-07-30 11:01
 * @description :
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    /*
    添加部门
     */

    public boolean adddept(Department dept) {
        int count = departmentMapper.insDept(dept);
        if (count > 0) {
            return true;
        }
        return false;
    }
    /*
    更新部门
     */

    public boolean updept(Department dept) {
        int count = departmentMapper.upDept(dept);
        if(count>0){
            return true;
        }
        return false;
    }
    /*
    删除部门
     */

    public boolean deldept(int did) {
        int count = departmentMapper.delDept(did);
        if(count>0){
            return true;
        }
        return false;
    }
    /*
        删除员工
     */

    public boolean delAll(int did) {
        int count = departmentMapper.delAll(did);
        if(count>0){
            return true;
        }
        return false;
    }


    public List<Department> findAllDept() {
        List<Department> dept = departmentMapper.selAllDept();
        if (dept!=null){
            return dept;
        }
        return null;
    }


    public Department findByDeptNo(int did) {
        Department dp = departmentMapper.selectByDeptNo(did);
        if(dp!=null){
            return dp;
        }
        return null;
    }


    public List<Department> findByDeptName(String dname) {
        List<Department> dp = departmentMapper.selectByDeptName(dname);
        if(dp!=null){
            return dp;
        }
        return null;
    }


    public List<Department> findByDeptManager(String dmg) {
        List<Department> dp = departmentMapper.selectByDeptManager(dmg);
        if (dp!=null){
            return dp;
        }
        return null;
    }

}
