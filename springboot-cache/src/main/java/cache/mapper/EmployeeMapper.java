package cache.mapper;

import cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * Created by sunlele
 * Date 2019/2/25 21:14
 * Description
 */
@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);


    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    public void updateEmp(Employee employee);

    @Delete("delete from employee where id=#{id}")
    public void deleteEmpById(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{d_id})")
    public void insertEmployee(Employee employee);
}
