package com.example.dao;

import com.example.model.Employee;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmployeeDAOFileImpl implements EmployeeDAO{
    private SortedMap<Integer, Employee> employees = new TreeMap<>();
    private SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy", Locale.US);
    private String fileName;

    public EmployeeDAOFileImpl(String fileName) {
        this.fileName = fileName;
    }

    private void syncData() throws DAOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // 先清空原始資料
            employees.clear();

            String line;
            while ((line = br.readLine()) != null && !line.trim().isEmpty()) {
                String[] data = line.split("\\|");
                try {
                    int id = Integer.parseInt(data[0]);
                    String firstName = data[1];
                    String lastName = data[2];
                    Date birthDate = df.parse(data[3]);
                    float salary = Float.parseFloat(data[4]);
                    // 生成並放入employee資料
                    Employee emp = new Employee(id, firstName, lastName, birthDate, salary);
                    employees.put(id, emp);
                } catch (ParseException|NumberFormatException e) {
                    System.err.printf("資料轉換錯誤:%s%n", line);
                }
            }
        } catch (IOException e) {
            throw new DAOException("資料讀取失敗", e);
        }
    }

    private void commit() throws DAOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            Set<Integer> index = employees.keySet();
            for (Integer i : index) {
                Employee emp = employees.get(i);
                // 1| Sean|Cheng|Mar 21, 1974|50000.00
                String line = String.format("%d|%s|%s|%s|%.2f",
                        emp.getId(), emp.getFirstName(), emp.getLastName(),
                        df.format(emp.getBirthDate()), emp.getSalary());
                pw.println(line);
            }
            pw.flush();
        } catch (IOException e) {
            throw new DAOException("資料寫出失敗", e);
        }
    }

    @Override
    public void add(Employee emp) throws DAOException {
        int id = emp.getId();
        if (employees.containsKey(id)) {
            throw new DAOException(id + "號員工已存在，新增失敗！");
        }
        employees.put(id, emp);
        commit();
    }

    @Override
    public void update(Employee emp) throws DAOException {
        int id = emp.getId();
        if (!employees.containsKey(id)) {
            throw new DAOException(id + "號員工不存在，修改失敗！");
        }
        employees.put(id, emp);
        commit();
    }

    @Override
    public void delete(int id) throws DAOException {
        if (!employees.containsKey(id)) {
            throw new DAOException(id + "號員工不存在，刪除失敗！");
        }
        employees.remove(id);
        commit();
    }

    @Override
    public Employee findById(int id) throws DAOException {
        syncData();
        Employee emp = employees.get(id);
        if (emp == null) {
            throw new DAOException(id + "號員工不存在！");
        }
        return emp;
    }

    @Override
    public Employee[] getAllEmployees() throws DAOException {
        syncData();
        return employees.values().toArray(new Employee[0]);
    }

    @Override
    public void close(){
        System.out.println("Resource is closing ...");
    }
}
