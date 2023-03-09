package LeetCode.arrays;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author zkx
 * @ClassName NextPermutation
 * @Description TODO 31. 下一个排列(medium) unsolved!
 * @Date 2022/9/21 11:30
 * Version 1.0
 * <p>
 * <p>
 * 4,5,2,6,3,1
 **/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    @Test
    public void test() {
        int[] nums = {4,5,2,6,3,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
