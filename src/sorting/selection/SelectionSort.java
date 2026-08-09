package sorting.selection;

import sorting.MyArrays;

public class SelectionSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = minElementIndex(arr, i, arr.length);
            MyArrays.swap(arr, i, minIndex);
        }
    }

    private static int minElementIndex(int[] arr, int start, int end) {
        int min = arr[start];
        int minIndex = start;
        for (int i = start + 1; i < end; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
