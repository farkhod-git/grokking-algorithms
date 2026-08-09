package sorting.insertion;

import sorting.MyArrays;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    MyArrays.swap(arr, j, j - 1);
                }
            }
        }
    }

    static void main() {
        int[] arr = {4, 5, 4, 3, 2, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
