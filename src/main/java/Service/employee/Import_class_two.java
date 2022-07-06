package Service.employee;



import Entity.Employee.Employee;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.*;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Component
@Qualifier("ps2")
@Profile("dev")
public class Import_class_two implements EmployeeService{
    @Override
    public List findAll() {
        ArrayList<String> list=new ArrayList<>();
        list.add("ps2");
        return list;
    }
    @Value("${prefix}")
    private String prefix;

    @Value("${sufix}")
    private String sufix;


    @Override
    public String getEmployeeNickname(String first_name, String last_name) {
        int lenght=last_name.length();
        Logger logger = LoggerFactory.getLogger(Import_class_one.class);
        logger.info(first_name+ " " + last_name);
        String answer=prefix+ first_name.substring(0,3)+last_name.substring(lenght-3)+sufix + " "+ "dev";
        logger.info(answer);

        return answer;
    }

    @Override
    public Employee findByName(String name, String surname) {
        ArrayList<Employee> listFound = new ArrayList<>(EMPLOYEE_MAP.values());
        for(Employee e : listFound){
            if(Objects.equals(e.getName(), name) && Objects.equals(e.getSurname(), surname)){
                return e;
            }
            else return null;
        }
        return null;
    }

    @Override
    public void save(Employee employee) {
        int count=EMPLOYEE_MAP.size();
        EMPLOYEE_MAP.put((long) (count+1),employee);
        System.out.println("Employee saved");
    }


}
