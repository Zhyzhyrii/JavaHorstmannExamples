package hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {

//        threshold = number of buckets * load factor (0.75 by default)
//        index = hashCode(key) & (n-1). n = amount of buckets or array size or initialCapacity (16 by default)
//        threshold = 12 (by default)

        Map<Key, Integer> map = new HashMap();
        map.put(new Key("vishal"), 20);
//        hash = 118
//        index = 118 & 15 = 6 - index of bucket
        map.put(new Key("sachin"), 30);
//        hash = 115
//        index = 115 & 15 = 3
        map.put(new Key("vaibhav"), 40);
//        hash = 118
//        index = 118 & 15 = 6 - index of bucket
//        using hashCode and equals verify whether both keys are equal or not
//        if yes - replace old value
//        otherwise put new object to the same bucket and link both elements via LinkedList or balanced red black tree node.
//        When there are at least 8 entries (TREEIFY_THRESHOLD) in a single bucket
//        and the total number of buckets is more then 64 (MIN_TREEIFY_CAPACITY)
//        then that single bucket will be transformed to a perfectly balanced red black tree node.
    }
}
