package rms.demo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import rms.demo.domain.Employee;

/**
 * Description: SSM01
 *
 * @author CM
 * Created by Administrator on 2019/7/26 10:50
 */
@Repository
public interface EmpMapper {

    List<Employee> listAllEmp ();


    int addEmp (Employee emp);

    @Update("UPDATE employee SET ename=#{ename},sex=#{sex},workdate=#{workdate}, did=#{did},pid=#{pid},identity=#{identity},phone=#{phone}, address=#{address},birthday=#{birthday} WHERE eid=#{eid}")
    int updateEmp (Employee emp);

    @Delete("DELETE FROM employee WHERE eid=#{id}")
    int deleteEmp (int id);

    List<Employee> selectEmpAll ();

    @Select("SELECT * FROM employee WHERE ename LIKE #{name}")
    List<Employee> find (String name);

    @Select ("SELECT * FROM employee WHERE eid=#{eid}")
    Employee getEmpById (Integer eid);

}
