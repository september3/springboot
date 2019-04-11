package cache.service;

import cache.bean.Employee;
import cache.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by sunlele
 * Date 2019/2/27 23:09
 * Description
 */
@Service
@Slf4j
public class EmployeeService {

    @Resource
    EmployeeMapper employeeMapper;


    /**
     * @Cachable---将方法的运行结果进行缓存
     * @Cachable注解属性
     *  cacheName/value：指定缓存组件的名字
     *  key:缓存数据使用的key,默认使用方法参数的值
     *  cacheManager：缓存管理器
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"emp"})
    public Employee getEmp(Integer id){
        log.info("查询员工"+ id);
        Employee empById = employeeMapper.getEmpById(id);
        return empById;
    }
}
