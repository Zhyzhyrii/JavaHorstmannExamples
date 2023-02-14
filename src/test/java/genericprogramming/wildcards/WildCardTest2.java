package genericprogramming.wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildCardTest2 {
    public static void main(String[] args) {
        var ceo = new Manager("Gus Greedy", 10);
        var cfo = new Manager("Sid Sneaky", 5);
        ceo.setBonus(100);
        cfo.setBonus(1000);
        Pair<Manager> managers = new Pair<>(ceo, cfo);
        Pair<Employee> employeePair = new Pair<>();
        Pair<Executive> executivePair = new Pair<>();
        var gregManager = new Manager("Greg", 55);
        var gregEmployee = new Employee("Greg", 10);
        var gregExecutive = new Executive("Greg", 1000);

//        Pair<? extends Employee> wildcards = managers;//possible
//        wildcards = employeePair;//possible
//        wildcards = executivePair;//possible

//        Pair<? extends Manager> wildcards = managers;//possible
//        wildcards = employeePair;//impossible
//        wildcards = executivePair;//possible

//        Pair<? extends Executive> wildcards = managers;//impossible
//        wildcards = employeePair;//impossible
//        wildcards = executivePair;//possible

//        Pair<? extends Employee> wildcards = employeePair;//possible
//        wildcards.setFirst(gregManager);//compilation error - type
//        wildcards.setFirst(gregEmployee);//compilation error - type
//        wildcards.setFirst(gregExecutive);//compilation error - type

//        Pair<? super Employee> wildcards = employeePair;//possible
//        Pair<? super Employee> wildcards = managers;//impossible
//        Pair<? super Employee> wildcards = executivePair;//impossible
//        wildcards.setFirst(gregManager);//possible
//        wildcards.setFirst(gregEmployee);//possible
//        wildcards.setFirst(gregExecutive);//possible

//        Pair<? super Manager> wildcards = executivePair;//impossible
//        Pair<? super Manager> wildcards = managers;//possible
//        Pair<? super Manager> wildcards = employeePair;//possible
//        wildcards.setFirst(gregManager);//possible
//        wildcards.setFirst(gregEmployee);//impossible
//        wildcards.setFirst(gregExecutive);//possible

//        Pair<? super Executive> wildcards = employeePair;//possible
//        Pair<? super Executive> wildcards = executivePair;//possible
//        Pair<? super Executive> wildcards = managers;//possible

        Pair<? super Employee> wildcards = new Pair<>();
        wildcards.setFirst(gregManager);//possible
        wildcards.setFirst(gregEmployee);//possible
        wildcards.setFirst(gregExecutive);//possible
        wildcards.setSecond(gregEmployee);

//        Manager manager = wildcards.getFirst();//compilation error - type
//        Employee employee = wildcards.getFirst();//compilation error - type
//        Executive executive = wildcards.getFirst();//compilation error - type
        Object obj = wildcards.getFirst();//possible
        var manager = ((Manager) wildcards.getFirst());//possible
        var employee = ((Employee) wildcards.getFirst());//possible
        var executive = ((Executive) wildcards.getFirst());//possible
        var employeeTwoObject = wildcards.getSecond();//possible Object
        var employeeTwoEmployee = (Employee) wildcards.getSecond();//possible Employee
//        var employeeTwoManager = (Manager) wildcards.getSecond();//impossible, ClassCastException

        System.out.println(obj);

    }
}
