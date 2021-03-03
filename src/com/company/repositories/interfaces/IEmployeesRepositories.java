package com.company.repositories.interfaces;

import com.company.entities.Employees;

import java.util.List;

public interface IEmployeesRepositories {
            boolean addEmployee(Employees employees);
            Employees getEmployeeById(int id);
            Employees getEmployeeByName(String name);
            List<Employees> getAllEmployees();
            List<Employees> getEmployeesByJob(String speciality);
            boolean removeEmployeeByID(int id);
            Employees getEmployeeByDepartment(String department);
            List<Employees> getAcceptedEmployees();
}
