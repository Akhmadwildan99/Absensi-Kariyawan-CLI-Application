package test.service;

import entity.Employee;
import entity.IdEmployee;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class TestService {
    public static void main(String[] args) {
        testShowEmployee();
    }

    public static void testShowEmployee(){
        EmployeeRepository repository = new EmployeeRepositoryImpl();
        EmployeeService service = new EmployeeServiceImpl(repository);

        repository.getAllEmployee().put(new IdEmployee(1234), new Employee("wildan"));
        repository.getAllEmployee().put(new IdEmployee(1212), new Employee("akhmad"));

        service.showEmployee();
    }
}
