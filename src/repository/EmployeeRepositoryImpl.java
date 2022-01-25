package repository;

import entity.Employee;
import entity.IdEmployee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeRepositoryImpl implements EmployeeRepository{
    public Map<IdEmployee, Employee> employee = new HashMap<>();
    public ArrayList<Employee> work = new ArrayList<>();
    public Map<IdEmployee, Integer> workingDays = new HashMap<>();
    @Override
    public Map<IdEmployee, Employee> getAllEmployee() {
        return employee;
    }

    @Override
    public ArrayList<Employee> getAllWork() {
        return work;
    }

    @Override
    public Map<IdEmployee, Integer> getAllWorkingDays() {
        return workingDays;
    }

    @Override
    public boolean sign(IdEmployee idEmployee, Employee employee) {
        return false;
    }

    @Override
    public boolean in(IdEmployee idEmployee) {
        return false;
    }

    @Override
    public boolean out(IdEmployee idEmployee) {
        return false;
    }
}
