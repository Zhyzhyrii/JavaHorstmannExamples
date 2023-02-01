package stackwalkerexamples;

public class FactorialWithStackWalker {

    public static int factorial(int n) {
        System.out.println("factorial(" + n + "):");
        var walker = StackWalker.getInstance();
        walker.forEach(System.out::println);
        int r;
        if (n <=1 ) {
            r = 1;
        }
        else {
            r = n * factorial(n - 1);
        }
        System.out.println("return: " + r);
        return r;
    }
}
