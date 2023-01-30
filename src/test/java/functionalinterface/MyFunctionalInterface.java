package functionalinterface;

@FunctionalInterface
public interface MyFunctionalInterface {

    int DEF_VALUE = 4; //public static final

//    private int ff=3; compilation error - private does not allowed

    //1 abs methods == functional interface. If more - compilation error.
    //Static and default methods are possible.
    boolean test(Integer value); //public but when this method is going to be realized - public is needed.

    //one more abs. method is possible as “interfaces do not inherit from Object, but rather implicitly declare many of the same methods as Object.”
    boolean equals(Object obj);

//    Compilation error as there are 2 abstract methods;
//    boolean test2();

    default Integer prepareX2(int value) {
        return prepareXTwo(value);
    }

    static Integer prepareX3(int value) {
        return prepareXThree(value);
    }

    private Integer prepareXTwo(int value) {
        return value *= 2;
    }

    private static Integer prepareXThree(int value) {
        return value *= 3;
    }
}
