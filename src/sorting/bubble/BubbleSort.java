package sorting.bubble;

import sorting.MyArrays;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] arr) {
        for (int step = 0; step < arr.length - 1; step++) {
            for (int j = step; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    MyArrays.swap(arr, j, j + 1);
                }
            }
        }
    }

    static void main() {
        int[] arr = {8, 2, 7, 3, 6, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
