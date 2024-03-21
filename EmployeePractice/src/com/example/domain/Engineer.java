package src.com.example.domain;

public class Engineer extends Employee implements RegularStaff {
    private String[] skills = {};
    private int skillCount;

    @Override
    public double getPay() {
        return getSalary() + skillCount * 3000;
    }

    public Engineer(String name, String ssn, double salary, Branch branch) {
        super(name, ssn, salary, branch);
    }

    public void addSkills (String skill) {
        String[] temp = new String[++skillCount];
        System.arraycopy(skills, 0, temp, 0, skills.length);
        temp[skillCount - 1] = skill;
        skills = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        if (skillCount > 0) {
            sb.append("\nSkill Set[" + skillCount +"]:");
            for (String skill : skills) {
                sb.append(" " + skill);
            }
        }
        return sb.toString();
    }

    @Override
    public double getBonus() {
        return getSalary() * calcPerMultiplier();
    }
}
