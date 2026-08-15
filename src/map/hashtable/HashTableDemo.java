package map.hashtable;

import java.util.Hashtable;

public class HashTableDemo {
    static void main() {
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        ht.put(1, 11);
        ht.put(2, 22);

        ht.remove(1);
//        ht.putAll();
//        ht.keySet()

        System.out.println(ht);
    }
}
