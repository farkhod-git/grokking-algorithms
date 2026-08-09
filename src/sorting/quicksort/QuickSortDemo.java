package sorting.quicksort;

import sorting.MyArrays;

import java.util.Random;

public class QuickSortDemo {
    static void main() {
        Random random = new Random();
        int[] arr = new int[1_000_000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1_000_000);
        }
        long start = System.currentTimeMillis();
        QuickSort.sort(arr);
        long end = System.currentTimeMillis();

        System.out.println( "Time taken: " + (end - start) + " ms");

        System.out.println(MyArrays.isSorted(arr));
    }
}
