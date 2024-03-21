package com.example.domain;

import java.util.ArrayList;

public class Manager extends Employee implements RegularStaff {
    private double baseBonus = 100000;
    private String deptName = "業務部";
    protected ArrayList<Employee> employees = new ArrayList<>();

    public boolean addEmployee (Employee e) {
        if (employees.contains(e)) {
            System.out.println("該員工已在管轄資料中");
            return false;
        }
        return employees.add(e);
    }

    public boolean removeEmployee (Employee e) {
        if (!employees.contains(e)) {
            System.out.println("該員工不在管轄資料中");
            return false;
        }
        return employees.remove(e);
    }

    public String getStaffDetails() {
        StringBuilder sb = new StringBuilder();
        if (!employees.isEmpty()) {
            sb.append("\n----管轄名單----");
            for (Employee e : employees) {
                sb.append("\n(" + e.getEmpId() + ") "+ e.getName());
            }
            sb.append("\n---------------");
        }
        return sb.toString();
    }

    public Manager(String name, String ssn, double salary, Branch branch, String deptName) {
        super(name, ssn, salary, branch);
        if (!(deptName == null || deptName.isBlank())) {
            this.deptName = deptName;
        }
    }

    public String getDeptName() {
        return deptName;
    }

    @Override
    public double getPay() {
        return getSalary() + employees.size() * 2000;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartment: " + deptName + getStaffDetails();
    }

    @Override
    public double getBonus() {
        return baseBonus * calcPerMultiplier();
    }
}
