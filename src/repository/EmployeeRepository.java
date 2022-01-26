package repository;

import entity.Employee;
import entity.IdEmployee;

import java.util.ArrayList;
import java.util.Map;

public interface EmployeeRepository {
    Map<IdEmployee, Employee> getAllEmployee();

    ArrayList<Employee> getAllWork();

    Map<Integer, Integer> getAllWorkingDays();

    boolean sign(Employee employeeName);

    boolean in(Integer idEmployee);

    boolean out(Integer idEmployee);

}
