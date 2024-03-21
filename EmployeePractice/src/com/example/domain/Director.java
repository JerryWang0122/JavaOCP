package src.com.example.domain;

public class Director extends Manager {
    private double baseBonus = 500000;
    private double budget;
    public Director(String name, String ssn, double salary, Branch branch, String deptName, double budget) {
        super(name, ssn, salary, branch, deptName);
        this.budget = budget;
    }

    @Override
    public double getPay() {
        return getSalary() + employees.size() * 10000;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBudget: " + this.getBranch().getCurrency() + formatter.format(budget) + "元";
    }

    @Override
    public double getBonus() {
        return baseBonus * calcPerMultiplier();
    }
}
