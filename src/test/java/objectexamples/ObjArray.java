package objectexamples;

public class ObjArray {

    public static void main(String[] args) {
        String[] str = new String[10];
        str[0] = "str0";
        int[] ints = new int[10];
        ints[0] = 1;
        Object obj = str;
        System.out.println(obj.getClass());

        obj = ints;
        System.out.println(obj.getClass());
        /**
         * It is possible to assign an array to object variable
         * class [Ljava.lang.String;
         * class [I
         */
    }
}
