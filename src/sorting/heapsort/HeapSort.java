package sorting.heapsort;

import static sorting.MyArrays.swap;

public class HeapSort {
    public static void sort(int[] arr) {
        buildMaxHeap(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            siftDown(arr, 0, i);
        }
    }

    private static void buildMaxHeap(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, n);
        }
    }

    private static void siftDown(int[] arr, int i, int length) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < length) {
            if (arr[leftChild] > arr[largest]) {
                largest = leftChild;
            }

            if (rightChild < length && arr[rightChild] > arr[largest]) {
                largest = rightChild;
            }

            if (largest != i) {
                swap(arr, i, largest);
                siftDown(arr, largest, length);
            }
        }
    }

    public static void sortDesc(int[] arr) {
        buildMinHeap(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            siftDownMinHeap(arr, 0, i);
        }
    }

    private static void buildMinHeap(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDownMinHeap(arr, i, n);
        }
    }

    private static void siftDownMinHeap(int[] arr, int i, int length) {
        int smallest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < length) {
            if (arr[leftChild] < arr[smallest]) {
                smallest = leftChild;
            }

            if (rightChild < length && arr[rightChild] < arr[smallest]) {
                smallest = rightChild;
            }

            if (smallest != i) {
                swap(arr, i, smallest);
                siftDownMinHeap(arr, smallest, length);
            }
        }
    }
}
