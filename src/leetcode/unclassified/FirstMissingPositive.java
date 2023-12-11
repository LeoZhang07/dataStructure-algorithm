package leetcode.unclassified;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName FirstMissingPositive
 * @Description TODO 41. 缺失的第一个正数（hard)
 * @Date 2022/10/20 14:39
 * Version 1.0
 **/
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int currAbs;
        int MAX = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = MAX + 1;
                continue;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            currAbs = Math.abs(nums[i]);
            if (currAbs <= nums.length) {
                nums[currAbs - 1] = -Math.abs(nums[currAbs - 1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return MAX + 1;
    }

    @Test
    public void test() {
        int[] nums = {1, 1};
        //{3,4,-5,-1}
        System.out.println(firstMissingPositive(nums));
    }
}
