package cache.controller;

import cache.bean.Employee;
import cache.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**
 * Created by sunlele
 * Date 2019/2/27 23:12
 * Description
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Resource
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable(value = "id") Integer id){
        Employee emp = employeeService.getEmp(id);
        return emp;
    }
}
