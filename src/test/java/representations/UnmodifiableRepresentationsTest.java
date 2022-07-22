package representations;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UnmodifiableRepresentationsTest {

    public static void main(String[] args) {
        var staff = new LinkedList<String>();
        staff.add("Staff 1");

        var unmodifiableStaff = Collections.unmodifiableList(staff);
        System.out.println("Staff: " + staff);
        System.out.println("Umodifiable Staff: " + unmodifiableStaff);
        /*
        Staff: [Staff 1]
        Umodifiable Staff: [Staff 1]
         */

        staff.add("Staff 2");
        System.out.println("Staff: " + staff);
        System.out.println("Umodifiable Staff: " + unmodifiableStaff);
        /*
        Staff: [Staff 1, Staff 2]
        Umodifiable Staff: [Staff 1, Staff 2]
         */

        //unmodifiableStaff.add("Staff 3");
        //java.lang.UnsupportedOperationException

        var unmodifiableCollection = Collections.unmodifiableCollection(staff);
        System.out.println("unmodifiableCollection.equals(staff) - " + unmodifiableCollection.equals(staff));
        System.out.println("unmodifiableStaff.equals(staff) - " + unmodifiableStaff.equals(staff));
        /*
        unmodifiableCollection.equals(staff) - false
        unmodifiableStaff.equals(staff) - true
         */
    }
}
