package rms.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rms.demo.dao.SalaryMapper;
import rms.demo.domain.Salary;

/**
 * Description: SSM01
 *
 * @author CM
 * Created by Administrator on 2019/7/26 10:49
 */
@Service("salaryService")
public class SalaryServiceimpl   {
    @Autowired
    private SalaryMapper salaryMapper;


    public boolean addSalary(Salary salary){
        int count = salaryMapper.insertSalary(salary);
        if(count >0){
            return true;
        }
        return false;
    }


    public boolean removeSalary(String sid){
        int count = salaryMapper.deleteSalary(sid);
        if(count >0){
            return true;
        }
        return false;
    }



    public boolean modifySalary(Salary salary){
        int count = salaryMapper.updateSalary(salary);
        if(count>0){
            return true;
        }
        return false;
    }


    public Salary selectBySalary(String sid){
        Salary salary = salaryMapper.selectBySalary(sid);
        if (salary !=null){
            return salary;
        }
        return null;
    }


    public List<Salary> findSalaryAll(){
        List<Salary> salaries = salaryMapper.selectSalaryAll();
        if (salaries !=null){
            return salaries;
        }
        return null;
    }


    public List<Salary> selectBySalaryAll(Salary salary){
       List<Salary> salaries = salaryMapper.selectSalaryByParm(salary);
        if (salaries !=null){
            return salaries;
        }
        return null;
    }

    public List<Salary> selectBySalary1(String sid){
        List<Salary> salaries = salaryMapper.selectBySalary1(sid);
        if (salaries !=null){
            return salaries;
        }
        return null;
    }
}
