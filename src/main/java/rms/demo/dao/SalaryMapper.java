package rms.demo.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import rms.demo.domain.Salary;

/**
 * Description: SSM01
 *
 * @author CM
 * Created by Administrator on 2019/7/26 10:50
 */
@Repository
public interface SalaryMapper {
    /**
     * 添加工资
     */
    int insertSalary (Salary salary);
    /**
     * 删除工资
     */
    int deleteSalary (String sid);
    /**
     * 修改工资
     */
    int updateSalary (Salary salary);
    /**
     * 根据工资单号查找工资单
     */
    Salary selectBySalary (String sid);
    /**
     * 查找所有工资
     */
    List<Salary> selectSalaryAll ();
    /**
     * 模糊查询
     */
    List<Salary> selectSalaryByParm (Salary salary);
    List<Salary> selectBySalary1 (String sid);
}
