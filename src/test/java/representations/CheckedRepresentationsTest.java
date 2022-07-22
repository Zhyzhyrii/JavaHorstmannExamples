package representations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CheckedRepresentationsTest {

    public static void main(String[] args) {
        var strings = new ArrayList<String>();
        ArrayList rawList = strings;
        rawList.add("String 1");
        System.out.println("RawList: " + rawList);
        //RawList: [String 1]

        rawList.add(new Date());
        System.out.println("RawList: " + rawList);
        //RawList: [String 1]
        //RawList: [String 1, Fri Jul 22 22:19:35 EEST 2022]

        //String secondElement = (String)rawList.get(1);
        //java.lang.ClassCastException


        var strings2 = new ArrayList<String>();
        List<String> safeString = Collections.checkedList(strings2, String.class);
        List rawList2 = safeString;
        rawList2.add("String 3");
        System.out.println(rawList2);

        rawList2.add(new Date());
        //java.lang.ClassCastException
    }
}
