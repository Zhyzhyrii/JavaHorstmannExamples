package treeset;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeTest {

    public static void main(String[] args) {
        var parts = new TreeSet<Item>();
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Modem", 9912));
        System.out.println("Sort by part number (default):\n" + parts);

        var sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));
        sortByDescription.addAll(parts);
        System.out.println("Sort by description:\n" + sortByDescription);

        /*
         Sort by part number (default):
         [Item{description='Toaster', partNumber=1234}, Item{description='Widget', partNumber=4562}, Item{description='Modem', partNumber=9912}]
         Sort by description:
         [Item{description='Modem', partNumber=9912}, Item{description='Toaster', partNumber=1234}, Item{description='Widget', partNumber=4562}]
         */
    }
}
