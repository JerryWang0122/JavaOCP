package com.example.dao;

import com.example.model.Employee;

import java.util.SortedMap;
import java.util.TreeMap;

public class EmployeeDAOMapImpl implements EmployeeDAO{
    private SortedMap<Integer, Employee> employees = new TreeMap<>();

    @Override
    public void add(Employee emp) throws DAOException {
        int id = emp.getId();
        if (employees.containsKey(id)) {
            throw new DAOException(id + "號員工已存在，新增失敗！");
        }
        employees.put(id, emp);
    }

    @Override
    public void update(Employee emp) throws DAOException {
        int id = emp.getId();
        if (!employees.containsKey(id)) {
            throw new DAOException(id + "號員工不存在，修改失敗！");
        }
        employees.put(id, emp);
    }

    @Override
    public void delete(int id) throws DAOException {
        if (!employees.containsKey(id)) {
            throw new DAOException(id + "號員工不存在，刪除失敗！");
        }
        employees.remove(id);
    }

    @Override
    public Employee findById(int id) throws DAOException {
        Employee emp = employees.get(id);
        if (emp == null) {
            throw new DAOException(id + "號員工不存在！");
        }
        return emp;
    }

    @Override
    public Employee[] getAllEmployees() {
        return employees.values().toArray(new Employee[0]);
    }

    @Override
    public void close(){
        System.out.println("Resource is closing ...");
    }
}
