package com.example.lbddemo;

import Entity.Employee.Employee;
import Service.employee.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LbdDemoApplicationTests {

    @Autowired
    EmployeeService employeeService;
    @Test
    void contextLoads() {
        System.out.println(employeeService.getEmployeeNickname("Adam", "Rogalski"));
        Employee employee=new Employee(1L,"Adam", "Rogalski", "arogalski@fis-sst.pl", 123123123, "CEX123", 666256533);
        employeeService.save(employee);
        System.out.println(employeeService.findByName("Adam", "Rogalski").getName()
                + employeeService.findByName("Adam", "Rogalski").getSurname());
    }

}
