package rms.demo.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rms.demo.domain.Employee;
import rms.demo.domain.EmployeeExample;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("rms.demo.dao")
class EmployeeMapperTest {

    @Autowired
    EmployeeMapper mapper;

    @Test
    void test01(){
        EmployeeExample example = new EmployeeExample();
        example.createCriteria();
        List<Employee> employees = mapper.selectByExample(example);
        System.out.println(employees);
    }

    @Test
    void test02 () {
        List<Employee> list = mapper.selectLimited(10, 10);
        System.out.println(list);
    }

}