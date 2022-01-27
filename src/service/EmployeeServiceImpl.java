package service;

import entity.Employee;
import entity.IdEmployee;
import repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void showEmployee() {
        System.out.println("EMPLOYEE");

        Map<IdEmployee, Employee> allEmployee = repository.getAllEmployee();
        ArrayList<Employee> allWork = repository.getAllWork();
        Map<IdEmployee, Integer> allWorkingDays = repository.getAllWorkingDays();

        for (var key : allEmployee.keySet()){
            System.out.println("ID: "+ key.getId()+", KARIYAWAN: "+allEmployee.get(key).getName() + ", HARI KERJA: " + allWorkingDays.get(key));
        }
    }

    @Override
    public void signEmployee(String employee) {
        Employee employeeName = new Employee(employee);
        boolean sign = repository.sign(employeeName);
        if (!sign){
            System.out.println("PROSES SIGN NEW EMPLOYEE FAILED!!");
        }
    }

    @Override
    public void employeeIn(Integer id) {

    }

    @Override
    public void employeeOut(Integer id) {

    }
}
