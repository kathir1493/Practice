package kickstart.microsoft;

import java.util.Arrays;

class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        // Initialize the value as not found
        result[0] = -1;
        result[1] = -1;

        if (nums == null || nums.length < 1) {
            return result;
        }

        final int length = nums.length;

        if (target < nums[0]) {
            return result;
        }

        if (target > nums[length -1]) {
            return result;
        }

        findTarget(nums, target, 0, length - 1, result);

        return result;
    }

    private static void findTarget(int[] nums, int target, int start, int end, int[] result) {
        if (start > end) {
            return;
        }

        // Not in [start, end] range
        if (target < nums[start] || target > nums[end]) {
            return;
        }

        final int mid = (start + end)/2;

        if (target == nums[mid]) {
            if (result[0] == -1) {
                result[0] = mid;
                result[1] = mid;
            } else {
                if (mid < result[0]) {
                    result[0] = mid;
                }

                if (mid > result[1]) {
                    result[1] = mid;
                }
            }
        }

        findTarget(nums, target, start, mid - 1, result);
        findTarget(nums, target, mid + 1, end, result);
    }


    public static void main(String[] args){

        System.out.println(Arrays.toString(searchRange(new int[]{2, 2, 3, 5, 5, 6},2)));


    }
}
