package weakhashmap;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class WeakHashMapTest {

    @Test
    public void givenWeakHashMapWithOneKey_whenNoReferenceToKey_GCShouldReclaimThatObject() {
        KeyName fedorov = new KeyName("Fedorov");
        WeakHashMap<KeyName, String> weakHashMapEmployee = new WeakHashMap<>();
        weakHashMapEmployee.put(fedorov, "1993-01-01");
        System.out.println("Before fedorov = null WeakHashMap size = " + weakHashMapEmployee.size());

        fedorov = null;

        System.gc();
        Awaitility.await().atMost(10, TimeUnit.SECONDS).until(weakHashMapEmployee::isEmpty);
        System.out.println("After fedorov = null WeakHashMap is empty? - " + weakHashMapEmployee.isEmpty());
    }

    @Test
    public void givenWeakHashMapWithTwoKey_whenOneReferenceToKeyIsNull_GCShouldReclaimThatObject_mapShouldContainOnlyOneEntry() {
        KeyName antonov = new KeyName("Antonov");
        KeyName ivanov = new KeyName("Ivanov");
        WeakHashMap<KeyName, String> hashMapEmployee = new WeakHashMap<>();
        hashMapEmployee.put(antonov, "1993-01-01");
        hashMapEmployee.put(ivanov, "1991-01-01");

        System.out.println("Before ivanov = null WeakHashMap size = " + hashMapEmployee.size());

        ivanov = null;

        System.gc();
        Awaitility.await().atMost(10, TimeUnit.SECONDS).until(() -> hashMapEmployee.size() == 1);
        System.out.println("After ivanov = null WeakHashMap is empty? - " + hashMapEmployee.isEmpty());
        System.out.println("After ivanov = null WeakHashMap size = " + hashMapEmployee.size());
    }

    @Test
    public void givenHashMapWithTwoKey_whenOneReferenceToKeyIsNull_GCShouldNotReclaimThatObject_mapShouldContainTwoEntry() {
        KeyName antonov = new KeyName("Antonov");
        KeyName ivanov = new KeyName("Ivanov");
        HashMap<KeyName, String> hashMapEmployee = new HashMap<>();
        hashMapEmployee.put(antonov, "1993-01-01");
        hashMapEmployee.put(ivanov, "1991-01-01");

        System.out.println("Before ivanov = null HashMap size = " + hashMapEmployee.size());

        ivanov = null;

        System.gc();
        Awaitility.await().atMost(10, TimeUnit.SECONDS).until(() -> hashMapEmployee.size() == 2);
        System.out.println("After ivanov = null HashMap is empty? - " + hashMapEmployee.isEmpty());
        System.out.println("After ivanov = null HashMap size = " + hashMapEmployee.size());
    }

    static class KeyName {

        private final String name;

        public KeyName(String name) {
            this.name = name;
        }
    }

}

