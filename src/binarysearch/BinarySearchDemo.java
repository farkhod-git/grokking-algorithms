package binarysearch;

public class BinarySearchDemo {
    static void main() {
        int[] nums = {1, 3, 5, 7, 9};
        System.out.println("BinarySearch.search(nums, 3) = " + Search.binarySearch(nums, 3));
        System.out.println("BinarySearch.search(nums, 5) = " + Search.binarySearch(nums, -1));
    }
}
