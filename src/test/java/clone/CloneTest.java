package clone;

public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee original = new Employee("John", 5000);
        original.setHireDay(2000, 10, 10);

        Employee copy = original.clone();
        copy.raiseSalary(10);
        copy.setHireDay(2002, 1, 1);

        System.out.println("Original: " + original);
        System.out.println("Copy: " + copy);
    }
}
