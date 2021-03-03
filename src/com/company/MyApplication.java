package com.company;

import com.company.controllers.EmployeesController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final EmployeesController controller;
    private final Scanner scanner;

    public MyApplication(EmployeesController controller){
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start(){
        while (true){
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option: (0-6)");
            System.out.println("1. Add employee");
            System.out.println("2. Get employee by name");
            System.out.println("3. Get all employees");
            System.out.println("4. Get list of employees by job");
            System.out.println("5. Remove employee by ID");
            System.out.println("6. Get employee by department");
            System.out.println("7. Get employee by ID");
            System.out.println("8. Get accepted employees");
            System.out.println("0. Exit");
            try{
                System.out.println("Enter the option: (0-8)");
                int option = scanner.nextInt();
                if(option==1){
                    addEmployee();
                }
                else if(option ==2){
                    getEmployeeByName();
                }
                else if(option == 3){
                    getAllEmployees();
                }
                else if(option == 4){
                    getEmployeesByJob();
                }
                else if(option == 5){
                    removeEmployeeByID();
                }
                else if(option == 6){
                    getEmployeeByDepartment();
                }
                else if(option == 7){
                    getEmployeeById();
                }
                else if(option == 8){
                    getAcceptedEmployees();
                }
                else{
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            System.out.println("*******************************");
        }
    }
    public void getAllEmployees(){
        String response = controller.getAllEmployees();
        System.out.println(response);
    }
    public void getAcceptedEmployees(){
        String response = controller.getAcceptedEmployees();
        System.out.println(response);
    }
    public void getEmployeeById(){
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getEmployeeById(id);
        System.out.println(response);
    }

    public void getEmployeeByName(){
        System.out.println("Please enter name");
        String name = scanner.next();
        String response = controller.getEmployeeByName(name);
        System.out.println(response);
    }

    public void addEmployee(){
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter date of birth");
        String date = scanner.next();
        System.out.println("Please enter salary");
        double salary = scanner.nextDouble();
        System.out.println("Please enter speciality");
        String speciality = scanner.next();
        System.out.println("Please enter status");
        String status = scanner.next();
        System.out.println("Please enter department");
        String department = scanner.next();
        String response = controller.addEmployee(name, surname, date, salary, speciality, status, department);
        System.out.println(response);
    }
    public void removeEmployeeByID(){
        System.out.println("Enter ID");
        int id = scanner.nextInt();
        String response = controller.removeEmployeeByID(id);
        System.out.println(response);
    }

    public void getEmployeesByJob(){
        System.out.println("Please enter speciality");
        String speciality = scanner.next();

        String response = controller.getEmployeesByJob(speciality);
        System.out.println(response);
    }

    public void getEmployeeByDepartment(){
        System.out.println("Please enter department");
        String department = scanner.next();
        String response = controller.getEmployeeByDepartment(department);
        System.out.println(response);
    }
}
