package test.service;

import entity.Employee;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class TestService {
    public static void main(String[] args) {
        testInEmployee();
    }

    public static void testShowEmployee(){
        EmployeeRepository repository = new EmployeeRepositoryImpl();
        EmployeeService service = new EmployeeServiceImpl(repository);

//        repository.getAllEmployee().put(1234, new Employee("wildan"));
//        repository.getAllEmployee().put(1212, new Employee("akhmad"));

        service.showEmployee();
    }

    public static void testSignEmployee(){
        EmployeeRepository repository = new EmployeeRepositoryImpl();
        EmployeeService service = new EmployeeServiceImpl(repository);

        service.signEmployee("Akhmad");
        service.signEmployee("Wildan");
        service.signEmployee("WildanAkhmad");
        service.signEmployee(null);
        service.signEmployee("");

        service.showEmployee();
    }

    public static void testInEmployee(){
        EmployeeRepository repository = new EmployeeRepositoryImpl();
        EmployeeService service = new EmployeeServiceImpl(repository);

        service.signEmployee("Akhmad");
        service.signEmployee("Wildan");
        service.signEmployee("WildanAkhmad");

        service.showEmployee();

        service.employeeIn(1123);
        service.employeeIn(1124);
        service.employeeIn(1125);
        service.employeeIn(1123);
        service.employeeIn(null);
        service.employeeIn(1126);
        service.employeeIn(1126);

        service.showEmployee();
    }

    public static void testOutEmployee(){
        EmployeeRepository repository = new EmployeeRepositoryImpl();
        EmployeeService service = new EmployeeServiceImpl(repository);

        service.signEmployee("Akhmad");
        service.signEmployee("Wildan");
        service.signEmployee("WildanAkhmad");
        service.signEmployee("WildanAkhmad");
        service.employeeIn(1123);
        service.employeeIn(1124);
        service.employeeIn(1125);
        service.showEmployee();

        service.employeeOut(1123);
        service.employeeOut(1124);
        service.employeeOut(1125);
        service.employeeOut(1126);
        service.employeeOut(1123);

        service.showEmployee();
        service.employeeIn(1123);
        service.employeeIn(1124);
        service.employeeIn(1125);
        service.employeeIn(1126);
        service.employeeOut(1126);
        service.employeeOut(1124);
        service.employeeOut(1125);
        service.employeeOut(1123);


        service.showEmployee();
    }
}
