package com.example.lbddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //(scanBasePackages = "Service.employee")

public class LbdDemoApplication {

    //@Autowired
    //EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(LbdDemoApplication.class, args);
    }
}
