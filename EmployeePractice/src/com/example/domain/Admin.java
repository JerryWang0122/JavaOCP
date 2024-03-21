package src.com.example.domain;

public class Admin extends Employee{

    private int hours = 160;

    @Override
    public double getPay() {
        return getSalary() * hours / 160;
    }

    public Admin(String name, String ssn, double salary, Branch branch, int hours) {
        super(name, ssn, salary, branch);
        this.hours = hours;
    }
}
