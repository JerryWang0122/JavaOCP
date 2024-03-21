package com.example.dao;

import com.example.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOMemoryImpl implements EmployeeDAO{
    private Employee[] employeeArray = new Employee[10];

    @Override
    public void add(Employee emp) throws DAOException {
        try {
            if (employeeArray[emp.getId()] != null) {
                throw new DAOException("Employee ID has already existed! Add failed!");
            }
            employeeArray[emp.getId()] = emp;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DAOException("Employee ID should be less than 10! Add failed!", e);
        }
    }

    @Override
    public void update(Employee emp) throws DAOException {
        try {
            if (employeeArray[emp.getId()] == null) {
                throw new DAOException("Employee Information with empID("
                        + emp.getId() + ") is empty! Update failed!");
            }
            employeeArray[emp.getId()] = emp;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DAOException("Employee ID should be less than 10! Update failed!", e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        try {
            if (employeeArray[id] == null) {
                throw new DAOException("Employee Information with empID("
                        + id + ") is empty! Delete failed!");
            }
            employeeArray[id] = null;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DAOException("Employee ID should be less than 10! Delete failed!", e);
        }
    }

    @Override
    public Employee findById(int id) throws DAOException {
        try {
            return employeeArray[id];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DAOException("Employee ID should be less than 10! Search failed!", e);
        }
    }

    @Override
    public Employee[] getAllEmployees() {
        List<Employee> emps = new ArrayList<>();
        // Iterate through the memory array and find Employee objects
        for (Employee e : employeeArray) {
            if (e != null) {
                emps.add(e);
            }
        }
        return emps.toArray(new Employee[0]);
    }

    @Override
    public void close() {
        System.out.println("Resource is closing ...");
    }
}
