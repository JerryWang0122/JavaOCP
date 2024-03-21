package com.example.domain;

import java.text.NumberFormat;
import java.util.Objects;

@SuppressWarnings({"all"})
public abstract class Employee {
    private static int nextId = 101;
    private int empId;
    private String name = "隔壁老王";
    private String ssn;
    private double salary;
    private Branch branch;

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Branch getBranch() {
        return branch;
    }

    // format helper
    protected NumberFormat formatter = NumberFormat.getInstance();

    public abstract double getPay();

    public Employee(String name, String ssn, double salary, Branch branch) {
        this.empId = nextId++;
        this.setName(name);
        if (ssn != null && ssn.length() != 0) {
            this.ssn = ssn;
        }
        if (salary > 27420) {
            this.raiseSalary(salary);
        } else {
            this.raiseSalary(27420);
            System.out.println("薪水過低，使用預設最低薪資");
        }
        this.branch = branch;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) return;
        this.name = name.trim();
    }

    public void raiseSalary(double increase) {
        if (increase < 0) {
            System.out.println("Invalid increase");
            return;
        }
        salary += increase;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId && Objects.equals(ssn, employee.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, ssn);
    }

    @Override
    public String toString() {
        return "== Employee Information ==\nID: " + empId
            + "\nName: " + name + "\nSSN: " + ssn
            + "\nSalary: " + branch.getCurrency() + formatter.format(salary) + "元";
    }

}
