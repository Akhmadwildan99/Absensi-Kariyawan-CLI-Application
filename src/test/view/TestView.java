package test.view;

import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import view.ApplicationView;

public class TestView {
    public static void main(String[] args) {
        testApplication();
    }

    public static void testAdminPage(){
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository);
        ApplicationView applicationView = new ApplicationView(employeeService);

        applicationView.adminApplication("Admin");
    }

    public static void testApplication(){
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository);
        ApplicationView applicationView = new ApplicationView(employeeService);

        applicationView.application();
    }
}
