package binarysearch;

public class Search {
    /**
     * O(log<sub>2</sub>n)
     * @param nums numbers
     * @param target searching element
     * @return its position if element finds, or else returns null
     */
    public static Integer binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }  else if (nums[mid] < target) {
                left = mid + 1;
            }  else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static Integer linerSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return null;
    }
}
