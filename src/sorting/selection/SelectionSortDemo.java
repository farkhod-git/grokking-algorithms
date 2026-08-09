package sorting.selection;

import java.util.Arrays;

public class SelectionSortDemo {
    static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 8, 7, 6, 1, 2, 7, 8, 6, 3, 6, 1, 9, 8, 2};
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
