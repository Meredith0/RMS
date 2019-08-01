package rms.demo.dao;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import rms.demo.domain.Department;

public interface DepartmentMapper {

    @Select("SELECT count(*) FROM department WHERE did=#{did}")
    int validateDeptId (int did);

    List<Department> selAllDept(); //查询全部部门的信息

    Department selectByDeptNo(int did); //根据部门id进行查找

    List<Department> selectByDeptName(String dname); //根据部门名称进行查找

    List<Department> selectByDeptManager(String dmg); //根据部门主管进行查找

    int insDept(Department dept); //添加部门

    int delDept(int id); //根据部门id删除

    int upDept(Department dept); //根据部门的id进行修改

    int delAll(int did);
}
