package com.company.controllers;

import com.company.entities.Employees;
import com.company.repositories.interfaces.IEmployeesRepositories;

import java.util.List;

public class EmployeesController {
    private final IEmployeesRepositories repo;

    public EmployeesController(IEmployeesRepositories repo) {
        this.repo = repo;
    }

    public String addEmployee(String name, String surname, String date, double salary, String speciality, String status, String department){
        Employees employees = new Employees(name, surname, date, salary, speciality, status, department);
        boolean created = repo.addEmployee(employees);

        return (created ? "Employee was added successfully!" : "Employee adding was failed!");

    }
    public String getEmployeeById(int id){
        Employees employees = repo.getEmployeeById(id);

        return (employees == null ? "Employee not found!" : employees.toString());
    }
    public String getAllEmployees(){
        List<Employees> employeesTable = repo.getAllEmployees();
        return employeesTable.toString();
    }
    public String getAcceptedEmployees(){
        List<Employees> employeesTable = repo.getAcceptedEmployees();
        return employeesTable.toString();
    }
    public  String getEmployeeByName(String name){
        Employees employees = repo.getEmployeeByName(name);
        return (employees == null ? "Employee was not found!" : employees.toString());
    }
    public String removeEmployeeByID(int id){
        Employees employees = new Employees();
        boolean deleted = repo.removeEmployeeByID(id);

        return (deleted ? "Employee was deleted successfully!" : "Employee deleting was failed!");

    }

    public String getEmployeeByDepartment(String department){
        Employees employees = repo.getEmployeeByDepartment(department);
        return employees.toString();
    }
    public String getEmployeesByJob(String speciality){
        List<Employees> employeesTable = repo.getEmployeesByJob(speciality);
        return (employeesTable.toString());
    }
}
