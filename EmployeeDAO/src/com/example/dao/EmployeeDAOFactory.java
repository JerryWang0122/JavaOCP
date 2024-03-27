package com.example.dao;

public class EmployeeDAOFactory {
    public EmployeeDAO createEmployeeDAO() {
        return new EmployeeDAOFileImpl("employees.txt");
    }
}
