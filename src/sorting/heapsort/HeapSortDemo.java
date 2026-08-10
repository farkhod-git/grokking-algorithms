package sorting.heapsort;

import sorting.MyArrays;

import java.util.Random;

public class HeapSortDemo {
    static void main() {
        Random random = new Random();
        int[] arr = new int[10_000_000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10_000_000);
        }

        long start = System.currentTimeMillis();
        HeapSort.sortDesc(arr);
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");
        System.out.println(MyArrays.isSortedDesc(arr));

    }
}
