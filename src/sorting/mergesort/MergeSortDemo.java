package sorting.mergesort;

import sorting.MyArrays;

import java.util.Random;

public class MergeSortDemo {
    static void main() {
        Random random = new Random();
        int[] arr = new int[10_000_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        long s = System.currentTimeMillis();
        MergeSort.sort(arr);
        long e = System.currentTimeMillis();
        System.out.println("Time taken: " + (e - s) + " ms");
        System.out.println(MyArrays.isSorted(arr));
    }
}
