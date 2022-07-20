package priorityqueue;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        var pq = new PriorityQueue<LocalDate>();
        pq.add(LocalDate.of(1906, 12, 9));
        pq.add(LocalDate.of(1903, 6, 22));
        pq.add(LocalDate.of(1815, 12, 10));
        pq.add(LocalDate.of(1906, 6, 22));

        System.out.println("Iterating over elements...");
        for (var date : pq)
            System.out.println(date);

        /*
          Iterating over elements...
          1815-12-10
          1906-06-22
          1903-06-22
          1906-12-09
         */

        System.out.println("Removing elements...");
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
        /*
         Removing elements...
         1815-12-10
         1903-06-22
         1906-06-22
         1906-12-09
         */
    }
}
