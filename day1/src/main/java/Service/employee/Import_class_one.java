package Service.employee;

import Entity.Employee.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier("ps1")
@Primary
@Profile("prod")
public class Import_class_one implements EmployeeService{
    @Override
    public List findAll() {
        List<String> list=new ArrayList<>();
        list.add("ps1");
        return list;
    }

    @Value("${prefix}")
    private String prefix;

    @Value("${sufix}")
    private String sufix;


    @Override
    public String getEmployeeNickname(String first_name, String last_name) {
        int lenght=last_name.length();
        return prefix+ first_name.substring(0,3)+last_name.substring(lenght-3)+sufix;
    }

    @Override
    public Employee findByName(String name, String surname) {
        return null;
    }

    @Override
    public void save(Employee employee) {

    }


}
