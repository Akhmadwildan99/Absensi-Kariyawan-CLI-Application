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

    public IdEmployee generateId(){
        IdEmployee id = new IdEmployee();
        for (var i =  1123; i < 10000; i++){
            IdEmployee key = new IdEmployee(i);
          if (!employee.containsKey(key)){
              id = key;
              break;
          }
        }
        return id;
    }

    @Override
    public boolean sign(Employee employeeName) {
        //Set<Map.Entry<IdEmployee, Employee>> entries = employee.entrySet();
        IdEmployee id = generateId();
        employee.put(id, employeeName);
        workingDays.put(id, 0);
        System.out.println("Id anda \" " + employeeName.getName() + " \" : " + id.getId());
        return true;
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
