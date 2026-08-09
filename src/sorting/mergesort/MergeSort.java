package sorting.mergesort;

public class MergeSort {
    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1, new int[arr.length / 2 + 1]);
    }

    private static void mergeSort(int[] arr, int low, int high, int[] temp) {
        if (low >= high)
            return;

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid, temp);
        mergeSort(arr, mid + 1, high, temp);

        int tempLength = mid - low + 1;
        System.arraycopy(arr, low, temp, 0, tempLength);

        int i = low;
        int ai = mid + 1;
        int ti = 0;

        while (ai <= high && ti < tempLength) {
            if (arr[ai] <= temp[ti]) {
                arr[i++] = arr[ai++];
            } else {
                arr[i++] = temp[ti++];
            }
        }

        if (ai == high + 1) {
            System.arraycopy(temp, ti, arr, i, tempLength - ti);
        }
    }
}
