package com.company.entities;

public class Employees {
    private int id;
    private String name;
    private String surname;
    private String date;
    private double salary;
    private String speciality;
    private String status;
    private String department;

    public Employees(){};

    public Employees(String name, String surname, String date, double salary, String speciality, String status, String department) {
        setName(name);
        setSurname(surname);
        setDate(date);
        setSalary(salary);
        setSpeciality(speciality);
        setStatus(status);
        setDepartment(department);
    }

    public Employees(int id, String name, String surname, String date, double salary, String speciality, String status, String department) {
        setId(id);
        setName(name);
        setSurname(surname);
        setDate(date);
        setSalary(salary);
        setSpeciality(speciality);
        setStatus(status);
        setDepartment(department);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", date='" + date + '\'' +
                ", salary=" + salary +
                ", speciality='" + speciality + '\'' +
                ", status='" + status + '\'' +
                ", department='" + department + '\'' +
                '}' +'\n';
    }
}
