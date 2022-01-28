package repository;

import entity.Employee;
import entity.IdEmployee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeRepositoryImpl implements EmployeeRepository{
    private Map<IdEmployee, Employee> employee = new HashMap<>();
    private ArrayList<IdEmployee> work = new ArrayList<>();
    private Map<IdEmployee, Integer> workingDays = new HashMap<>();

    @Override
    public Map<IdEmployee, Employee> getAllEmployee() {
        return employee;
    }

    @Override
    public ArrayList<IdEmployee> getAllWork() {
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
        if (employeeName.getName() != null && !employeeName.getName().isBlank()){
            IdEmployee id = generateId();
            employee.put(id, employeeName);
            workingDays.put(id, 0);
            System.out.println("Id anda \" " + employeeName.getName() + " \" : " + id.getId());
            return true;
        }
        return false;

    }

    // Cek apakah ID exist di Map employee
    public boolean idExist(IdEmployee idEmployee){
        if (this.employee.containsKey(idEmployee)){
            return true;
        }
        return false;
    }

    // Cek apakah employee sedang bekerja
    public boolean employeeExist(IdEmployee idEmployee){
        if (this.work.contains(idEmployee)){
            return true;
        }
        return false;
    }

    @Override
    public boolean in(IdEmployee idEmployee) {
        boolean existId = idExist(idEmployee);
        if (existId){
            boolean exist = employeeExist(idEmployee);
            if (exist){
                return false;
            }
            this.work.add(idEmployee);
            return true;
        }
        return false;
    }

    @Override
    public boolean out(IdEmployee idEmployee) {
        boolean existId = idExist(idEmployee);
        if (existId){
            boolean exist = employeeExist(idEmployee);
            if (exist){
                work.remove(idEmployee);
                Integer work = workingDays.get(idEmployee);
                Integer workInt;
                workInt = ++work;
                workingDays.put(idEmployee, workInt);
                return true;
            }
        }
        return false;
    }
}
