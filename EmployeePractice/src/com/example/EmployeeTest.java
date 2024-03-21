package com.example;

import com.example.domain.*;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] emps = new Employee[5];
        emps[0] = new Admin("Sean", "A123456789", 50000, Branch.Taipei, 180);
        emps[1] = new Admin("Amy", "B210987654", 70000, Branch.London, 120);
        emps[2] = new Engineer("David", "C109876543", 80000, Branch.Tokyo);
        emps[3] = new Manager("Louis", "D124680135", 100000, Branch.Taipei, "TW Sales");
        emps[4] = new Director("Nicole", "R202468135", 120000, Branch.Paris,"Global Sales", 1000000);

        System.out.println("David learned Java and Android!");
        ((Engineer)emps[2]).addSkills("Java");
        ((Engineer)emps[2]).addSkills("Android");

        System.out.println("部門分配....");
        for (Employee emp : emps) {
            if (emp instanceof Manager){
                Manager m = (Manager) emp;
                if (emp instanceof Director) {
                    m.addEmployee(emps[3]);
                } else {
                    m.addEmployee(emps[0]);
                    m.addEmployee(emps[1]);
                    m.addEmployee(emps[2]);
                }
            }
        }

        for (Employee emp : emps) {
            System.out.println(emp);
            System.out.println("本月薪資 " + emp.getBranch().getCurrency() + emp.getPay() + "元");
            if (emp instanceof RegularStaff) {
                System.out.println("年終獎金：" + emp.getBranch().getCurrency() + ((RegularStaff) emp).getBonus() + "元");
                System.out.println("尾牙摸彩得到：" + RegularStaff.getLuckDraw());
            }
        }
    }
}
