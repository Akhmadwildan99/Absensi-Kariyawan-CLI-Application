package repository;

import entity.Employee;
import entity.IdEmployee;

import java.util.ArrayList;
import java.util.Map;

public interface EmployeeRepository {
    Map<IdEmployee, Employee> getAllEmployee();

    ArrayList<IdEmployee> getAllWork();

    Map<IdEmployee, Integer> getAllWorkingDays();

    boolean sign(Employee employeeName);

    boolean in(IdEmployee idEmployee);

    boolean out(IdEmployee idEmployee);

}
