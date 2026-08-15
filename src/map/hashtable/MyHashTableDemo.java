package map.hashtable;

import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class MyHashTableDemo {
    static void main() {
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        MyHashTable myHt = new MyHashTable();

        Random random = new Random();
        int n = 100;
        for (int i = 0; i < n; i++) {
            int key = random.nextInt(n);
            int val = random.nextInt(n);
            if (!Objects.equals(ht.put(key, val), myHt.put(key, val)))
                System.out.println("Put failed");
        }

        for (int i = 0; i < n/100; i++) {
            if (!Objects.equals(ht.remove(i), myHt.remove(i))) {
                System.out.println("Remove failed");
                return;
            }
        }

        for (var entry : ht.entrySet()) {
            Integer val = myHt.get(entry.getKey());
            if (!Objects.equals(val, entry.getValue())) {
                System.out.println("Not equal");
                break;
            }
        }

//        myHt.clear();
        int a = 0x7FFFFFFF;
        int b = Integer.MAX_VALUE;
        System.out.println(a);
        System.out.println(b);

        System.out.println("End");
    }

    public static void show(MyHashTable.MyEntry[] table) {

        for (int i = 0; i < table.length; i++) {
            MyHashTable.MyEntry entry = table[i];
            System.out.print(i + "[");
            while (entry != null) {
                System.out.print("{" + entry.key + "=" + entry.val + "}, ");
                entry = entry.next;
            }
            System.out.println("]");
        }

        System.out.println("\n");
    }
}
