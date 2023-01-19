package initialization;

import java.util.Calendar;

public class FieldInitByDefaultValues {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        var harry = new Employee("New name!!");
//        Date h = harry.getHireDay();
//        calendar.setTime(h); //NPE as h = null
    }
}
