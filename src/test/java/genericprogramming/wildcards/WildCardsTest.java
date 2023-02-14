package genericprogramming.wildcards;

import java.util.ArrayList;
import java.util.List;

public class WildCardsTest {
    public static void main(String[] args) {
        var ceo = new Manager("Gus Greedy", 10);
        var cfo = new Manager("Sid Sneaky", 5);
        ceo.setBonus(100);
        cfo.setBonus(1000);
        Manager[] managers = { ceo, cfo };
        var result = new Pair<Employee>();//Possible Manager, Employee, Object, but Executive is impossible (for the following method)
        minmaxBonus(managers, result);
        System.out.println("Minimum: " + result.getFirst());
        System.out.println("Maximum: " + result.getSecond());
    }

    //We should use PECS rule (producer extends Consumer super)
    //parameter is a producer when - methods reads data from the parameter
    //parameter is a consumer when - methods pass the data into the parameter

    // or Put and Get principle (use an extends wildcard when you only get values out of a structure,
    // use a super wildcard when you only put values into a structure)
    // and do not use a wildcard when you both get and put
    public static void minmaxBonus(Manager[] a, Pair<? super Manager> result) {
        if(a == null || a.length == 0) return;
        var min = a[0];
        var max = a[0];
        for (int i = 1; i < a.length; i++) {
            if(min.getBonus() > a[i].getBonus()) min = a[i];
            if (max.getBonus() < a[i].getBonus()) max = a[i];
        }
        result.setFirst(min); //if parameter Pair<? extends Employee> result - compilation error (type)
        result.setSecond(max);
    }
}
