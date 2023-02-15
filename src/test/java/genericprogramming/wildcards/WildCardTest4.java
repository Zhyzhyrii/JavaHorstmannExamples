package genericprogramming.wildcards;

public class WildCardTest4 {
    public static void main(String[] args) {
        var ceo = new Manager("Gus Greedy", 10);
        var cfo = new Manager("Sid Sneaky", 5);
        ceo.setBonus(100);
        cfo.setBonus(1000);
        Manager[] managers = { ceo, cfo };
        var result = new Pair<Employee>();
        minmaxBonus(managers, result);
        maxminBonus(managers, result);
    }

    public static void minmaxBonus(Manager[] a, Pair<? super Manager> result) {
        if(a == null || a.length == 0) return;
        var min = a[0];
        var max = a[0];
        for (int i = 1; i < a.length; i++) {
            if(min.getBonus() > a[i].getBonus()) min = a[i];
            if (max.getBonus() < a[i].getBonus()) max = a[i];
        }
//        var f = result.getSecond();//f has type Object
//        if parametr is Pair<? extends Employee> result then the f has Employee type
        result.setFirst(min); //if parameter Pair<? extends Employee> result - compilation error (type)
        result.setSecond(max);
    }

    public static void maxminBonus(Manager[] a, Pair<? super Manager> result)
    {
        minmaxBonus(a, result);
        PairAlg.swapHelper(result); // OK--swapHelper captures wildcard type
    }

    class PairAlg {
        public static void swap(Pair<?> p) {
            //Подстановка не является переменной типа, поэтому знак ? нельзя указывать место типа
//            ? t = p.getFirst(); //it is not possible. That is why we can use helpful swapHelper() method
//            p.setFirst(p.getSecond());
//            p.setSecond(t);

            swapHelper(p);//Параметр обощенного типа Т захватывает подстановку в этом вспомогательном методе.
        }

        public static <T> void swapHelper(Pair<T> p)
        {
            T t = p.getFirst();
            p.setFirst(p.getSecond());
            p.setSecond(t);
        }
    }
}
