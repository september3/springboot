package cache;

import cache.bean.Employee;
import cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {

    @Resource
    EmployeeMapper employeeMapper;
    @Test
    public void contextLoads() {
        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);
    }

}
