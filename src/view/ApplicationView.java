package view;

import exception.validationUtil.ValidationUtil;
import service.EmployeeService;
import util.InputUtil;

import java.util.concurrent.atomic.AtomicReference;

public class ApplicationView {
    private EmployeeService employeeService;

    public ApplicationView(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void application(){
        while (true){
            System.out.println("");
            String role = InputUtil.input("role: ");
            System.out.println("");
            if (role.equals("admin")){
                adminApplication(role);
            } else if (role.equals("employee")){
                employeeApplication();
            } else if (role.equals("x")){
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }

    }

    public void adminApplication(String admin){
        String adminLowerCase = admin.toLowerCase();
        while(adminLowerCase.equals("admin")){
            System.out.println("HALAMAN ADMIN");
            System.out.println("");
            employeeService.showEmployee();

            System.out.println();
            System.out.println("(+) untuk menambah Kariyawan baru!");
            System.out.println("(x) untuk kembali ke halaman utama applikasi!");
            String input = InputUtil.input("pilihan: ");
            if (input.equals("+")){
                signEmployeeShow();
            } else if (input.equals("x")){
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti!");
            }
        }

    }

    public void employeeApplication(){
        while (true){
            System.out.println("");
            System.out.println("KARIYAWAN ABSENSI");
            System.out.println("");
            String input = InputUtil.input("Masukan ID: ");
            System.out.println("1. in");
            System.out.println("2. out");
            System.out.println("x. cancel");
            String inputControllers = InputUtil.input("pilihan: ");
            Integer inputId = Integer.valueOf(input);
            if (inputControllers.equals("1")){
                employeeService.employeeIn(inputId);
            } else if (inputControllers.equals("2")){
                employeeService.employeeOut(inputId);
            }else if(inputControllers.equals("x")){
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti!");
            }

        }

    }


    public void signEmployeeShow(){
        String input = InputUtil.input("Nama Kariyawan: ");
        employeeService.signEmployee(input);
    }
}
