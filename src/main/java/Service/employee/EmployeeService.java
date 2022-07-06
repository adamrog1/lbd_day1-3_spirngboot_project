package Service.employee;

import Entity.Employee.Employee;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public interface EmployeeService {
    public List findAll();
    public String getEmployeeNickname(String first_name, String last_name);
    Map<Long, Employee> EMPLOYEE_MAP= new HashMap<>();
    public Employee findByName(String name, String surname);
    public void save(Employee employee);

}
