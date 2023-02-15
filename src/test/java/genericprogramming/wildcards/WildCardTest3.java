package genericprogramming.wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class WildCardTest3 {
    public static void main(String[] args) {
        var ceo = new Manager("Gus Greedy", 11);
        var cfo = new Manager("Sid Sneaky", 22);
        var gregManager = new Manager("Greg", 41);
        var gregEmployee = new Employee("Greg", 10);
        var gregExecutive = new Executive("Greg", 1001);

        ArrayList<Employee> staff = new ArrayList<>(Arrays.asList(ceo, cfo, gregManager, gregEmployee, gregExecutive));
        Predicate<Employee> evenSalary = employee -> employee.getSalary() % 2 == 0;//Possible as Predicate<? super Employee)
        staff.removeIf(evenSalary);

        Predicate<Object> oddHashCode = o -> o.hashCode() % 2 != 0;
        staff.removeIf(oddHashCode);//Possible as Predicate<? super Employee)
    }
}
