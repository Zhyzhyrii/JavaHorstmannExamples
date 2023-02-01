package stackwalkerexamples;

import java.util.Scanner;

public class StackWalkerTest {

    public static void main(String[] args) {
        try (var in = new Scanner(System.in)) {//try with resources, Scanner implements Autocloseable int. (try with resources must implement Autocloseable int (method close())
            System.out.println("Enter n: ");
            int n = in.nextInt();
            FactorialWithStackWalker.factorial(n);
        }
    }
}
