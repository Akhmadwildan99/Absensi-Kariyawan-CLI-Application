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
        System.out.println(" ");

        Map<IdEmployee, Employee> allEmployee = repository.getAllEmployee();
        ArrayList<IdEmployee> allWork = repository.getAllWork();
        Map<IdEmployee, Integer> allWorkingDays = repository.getAllWorkingDays();

        for (var key : allEmployee.keySet()){
            System.out.println("ID: "+ key.getId()+", KARIYAWAN: "+allEmployee.get(key).getName() + ", HARI KERJA: " + allWorkingDays.get(key));
        }

        System.out.println(" ");
        System.out.println("WORKING");
        for (var work : allWork){
            System.out.println(work.getId() + " || " + allEmployee.get(work).getName());
        }
        System.out.println(allWork.size()+ " Sedang bekerja");
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
        IdEmployee idEmployee = new IdEmployee(id);
        boolean workIn = repository.in(idEmployee);
        if (!workIn){
            System.out.println("ID GAGAL DITERIMA, COBA LAGI");
        }else {
            System.out.println("ID DITERIMA, SELAMAT BEKERJA");
        }
    }

    @Override
    public void employeeOut(Integer id) {
        IdEmployee idEmployee = new IdEmployee(id);
        boolean workOut = repository.out(idEmployee);
        if (!workOut){
            System.out.println("ID GAGAL DITERIMA, COBA LAGI");
        } else {
            System.out.println("ID DITERIMA, SAMPAI JUMPA");
        }
    }
}
