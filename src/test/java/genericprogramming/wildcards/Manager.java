package genericprogramming.wildcards;

import genericprogramming.wildcards.Employee;

public class Manager extends Employee {

    private double bonus;

    @Override
    public String toString() {
        return super.toString() + "\nManager{" +
                "bonus=" + bonus +
                '}';
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, double salary) {
        super(name, salary);
    }
}
