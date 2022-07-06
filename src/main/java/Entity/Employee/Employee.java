package Entity.Employee;


import Service.employee.EmployeeService;

public class Employee {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private int person_number;
    private String id_number;
    private int telephone_number;

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }
    public Employee(Long id, String name, String surname, String email, int person_number, String id_number, int telephone_number){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.person_number=person_number;
        this.id_number=id_number;
        this.telephone_number=telephone_number;

    }
}
