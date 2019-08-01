package rms.demo.dao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith (SpringRunner.class)
@SpringBootTest
@MapperScan ("rms.demo.dao")
class OtherMapperTest {

    @Autowired
    OtherMapper mapper;

    @Test
    void deleteTest () {
        int i = mapper.deleteTest(1);
        System.out.println(i);
    }

    @Test
    void test(){
        // List<Map<String, String>> maps = mapper.ageReport();
        // maps.forEach(System.out::println);
    }
}