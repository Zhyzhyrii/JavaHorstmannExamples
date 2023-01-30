package functionalinterface;

public class TestFuncInterface {

    public static void main(String[] args) {
        MyFunctionalInterface myFuncInt = x -> x.equals(8);
        System.out.println(myFuncInt.test(8)); //true

        var twoXTwo = myFuncInt.prepareX2(MyFunctionalInterface.DEF_VALUE);
        System.out.println(myFuncInt.test(twoXTwo));//true

        var twoXThree = MyFunctionalInterface.prepareX3(3);
        System.out.println(myFuncInt.test(twoXThree)); //false
    }
}
