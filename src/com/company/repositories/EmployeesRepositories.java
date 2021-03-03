package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Employees;
import com.company.repositories.interfaces.IEmployeesRepositories;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeesRepositories implements IEmployeesRepositories {
    private final IDB db;

    public EmployeesRepositories(IDB db){
        this.db=db;
    }

    @Override
    public boolean addEmployee(Employees employees) {
        Connection con=null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO employeestable(name, surname, date, salary, speciality, status, department) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, employees.getName());
            st.setString(2, employees.getSurname());
            st.setString(3, employees.getDate());
            st.setDouble(4, employees.getSalary());
            st.setString(5, employees.getSpeciality());
            st.setString(6, employees.getStatus());
            st.setString(7, employees.getDepartment());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return false;
    }

    @Override
    public Employees getEmployeeById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, date, salary, speciality, status, department FROM employeesTable WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()){
                Employees employees = new Employees(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("date"),
                rs.getDouble("salary"),
                rs.getString("speciality"),
                rs.getString("status"),
                rs.getString("department"));

                return employees;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Employees getEmployeeByName(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, date, salary, speciality, status, department FROM employeesTable WHERE name=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employees employees = new Employees(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("date"),
                        rs.getDouble("salary"),
                        rs.getString("speciality"),
                        rs.getString("status"),
                        rs.getString("department"));
                return employees;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


    @Override
    public List<Employees> getAllEmployees() {
        Connection con=null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, date, salary, speciality, status, department FROM employeesTable";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Employees> employeesTable = new LinkedList<>();
            while (rs.next()) {
                Employees employees = new Employees(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("date"),
                    rs.getDouble("salary"),
                    rs.getString("speciality"),
                    rs.getString("status"),
                    rs.getString("department"));

                    employeesTable.add(employees);
            }
            return employeesTable;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Employees> getEmployeesByJob(String speciality) {
        Connection con=null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, date, salary, speciality, status, department FROM employeesTable WHERE speciality=?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, speciality);

            ResultSet rs = st.executeQuery();
            List<Employees> employeesTable = new LinkedList<>();
            while (rs.next()) {
                Employees employees = new Employees(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("date"),
                        rs.getDouble("salary"),
                        rs.getString("speciality"),
                        rs.getString("status"),
                        rs.getString("department"));

                employeesTable.add(employees);
            }
            return employeesTable;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


    @Override
    public boolean removeEmployeeByID(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM employeesTable WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            st.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Employees getEmployeeByDepartment(String department) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, date, salary, speciality, status, department FROM employeesTable WHERE department=? AND salary = (SELECT MAX(salary) FROM employeesTable)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, department);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employees employees = new Employees(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("date"),
                        rs.getDouble("salary"),
                        rs.getString("speciality"),
                        rs.getString("status"),
                        rs.getString("department"));

                return employees;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Employees> getAcceptedEmployees() {
        Connection con=null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, date, salary, speciality, status, department FROM employeesTable WHERE status='accepted'";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Employees> employeesTable = new LinkedList<>();
            while (rs.next()) {
                Employees employees = new Employees(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("date"),
                        rs.getDouble("salary"),
                        rs.getString("speciality"),
                        rs.getString("status"),
                        rs.getString("department"));

                employeesTable.add(employees);
            }
            return employeesTable;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


}
