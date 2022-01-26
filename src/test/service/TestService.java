package test.service;

import entity.Employee;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class TestService {
    public static void main(String[] args) {
        testSignEmployee();
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
        service.signEmployee("WildanAkhmad");

        service.showEmployee();
    }
}
