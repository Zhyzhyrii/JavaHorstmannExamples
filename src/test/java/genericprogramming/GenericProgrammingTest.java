package genericprogramming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.IntFunction;

public class GenericProgrammingTest {
    public static void main(String[] args) {
//        var table = new Pair<String>[10];//Generic Array creation is not allowed as after cleaning the raw type will be Pair[]

//        var table = (Pair<String>[]) new Pair<?>[10];// via ? type it is possible but there is a warning - unchecked cast;

        Collection<Pair<String>> table = new ArrayList<>();
        Pair<String> p1 = new Pair<>("1", "1");
        Pair<String> p2 = new Pair<>("2", "2");
        addAll(table, p1, p2);

        Pair<String>[] pairArray = array(p1, p2);//it is possible due to @SafeVarargs but see the code below
        Object[] objArray = pairArray;
        objArray[0] = new Pair<Integer>(1,3);
//        var first = pairArray[0].getFirst(); //compile is good but runtime exception java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String

//        var minMax = minMax("S", "As", "Bfdd"); //compile is good but runtime exception class [Ljava.lang.Object; cannot be cast to class [Ljava.lang.Comparable;
        var minMax = minMax(String[]::new, "Bb", "As", "po");// everything is ok
    }

    @SafeVarargs
    private static <T> void addAll(Collection<T> coll, T... ts) {//Possible heap pollution from parameterized vararg type because of vararg type T...
        for (T t : ts) {
            coll.add(t);
        }
    }

    @SafeVarargs
    static <E> E[] array(E... array) {
        return array;
    }

//    public static <T extends Comparable> T[] minMax(T... a) {
////        T[] mm = new T[2];//it is not possible - Type parameter T can not be instantiated directly.
//        Object[] mm = new Object[2];
//        mm[0] = a[0];
//        mm[1] = a[1];
//        return (T[]) mm;//unchecked cast warning
//    }

    public static <T extends Comparable> T[] minMax(IntFunction<T[]> constr, T... a) {
        T[] mm = constr.apply(2);
        mm[0] = a[0];
        mm[1] = a[1];
        return mm;//without warnings
    }
}
