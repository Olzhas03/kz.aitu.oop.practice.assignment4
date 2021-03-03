package com.company;

import com.company.controllers.EmployeesController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.entities.Employees;
import com.company.repositories.EmployeesRepositories;
import com.company.repositories.interfaces.IEmployeesRepositories;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IEmployeesRepositories repo = new EmployeesRepositories(db);
        EmployeesController controller = new EmployeesController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}
