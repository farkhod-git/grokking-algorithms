package dsa.map.hashtable;

import java.util.Map;

public class MyHashTable {

    private MyEntry[] table;
    private int count;
    private static final float loadFactor = 0.75f;
    private int threshold;

    public MyHashTable() {
        this.table = new MyEntry[3];
        this.threshold = (int) (table.length * loadFactor);
    }

    public Integer get(Integer key) {
        int hash = key.hashCode();
        int index = hash % table.length;
        MyEntry entry = table[index];

        while (entry != null) {
            if (entry.hash == hash && entry.key.equals(key)) {
                return entry.val;
            }
            entry = entry.next;
        }

        return null;
    }

    private void rehash() {
        MyEntry[] oldTable = table;
        MyEntry[] newTable = new MyEntry[oldTable.length * 2 + 1];

        for (MyEntry entry : oldTable) {
            while (entry != null) {
                MyEntry next = entry.next;

                int index = entry.hash % newTable.length;
                entry.next = newTable[index];
                newTable[index] = entry;

                entry = next;
            }
        }

        this.table = newTable;
        this.threshold = (int) (newTable.length * loadFactor);
    }

    public Integer put(Integer key, Integer value) {
        MyEntry[] tab = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;

        MyEntry entry = tab[index];

        for (; entry != null; entry = entry.next) {
            if (entry.hash == hash && entry.key.equals(key)) {
                Integer oldValue = entry.val;
                entry.val = value;
                return oldValue;
            }
        }

        if (count == threshold) {
            rehash();
            index = (hash & 0x7FFFFFFF) % table.length;
        }

        tab = table;
        tab[index] = new MyEntry(hash, key, value, tab[index]);
        count++;
        return null;
    }

    public Integer remove(Integer key) {
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % table.length;

        MyEntry[] tab = table;
        MyEntry entry = tab[index];
        if (entry == null) {
            return null;
        }

        if (entry.key.equals(key)) {
            tab[index] = entry.next;
            entry.next = null;
            count--;
            return entry.val;
        }

        while (entry.next != null) {
            MyEntry next = entry.next;

            if (next.hash == hash && next.key.equals(key)) {
                entry.next = next.next;
                next.next = null;
                count--;
                return next.val;
            }
        }

        return null;
    }

    public boolean containsKey(Integer key) {
        return get(key) != null;
    }

    public boolean containsValue(Integer value) {
        for (MyEntry entry : table) {
            while (entry != null) {
                if (entry.val.equals(value)) {
                    return true;
                }
                entry = entry.next;
            }
        }

        return false;
    }

    public void putAll(Map<? extends Integer, ? extends Integer> m) {
        m.forEach(this::put);
    }

    public void clear() {
        for (int i = 0; i < table.length; i++) {
            MyEntry myEntry = table[i];
            while (myEntry != null) {
                MyEntry next = myEntry.next;
                myEntry.next = null;
                myEntry = next;
            }
            table[i] = null;
        }

        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public static class MyEntry {
        final int hash;
        final Integer key;
        Integer val;
        MyEntry next;

        public MyEntry(int hash, Integer key, Integer val, MyEntry next) {
            this.hash = hash;
            this.key = key;
            this.val = val;
            this.next = next;
        }

        public String toString() {
            return key + "=" + val;
        }
    }
}
