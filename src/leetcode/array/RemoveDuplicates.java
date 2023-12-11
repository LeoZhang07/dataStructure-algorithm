package leetcode.array;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName RemoveDuplicates
 * @Description TODO 26. 删除有序数组中的重复项(easy)
 * @Date 2022/9/20 15:41
 * Version 1.0
 **/
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[slow]) {
                continue;
            }
            slow++;
            nums[slow] = nums[i];
        }
        return slow + 1;
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }
}
