package LeetCode.arrays;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName RemoveElement
 * @Description TODO 27. 移除元素(easy)
 * @Date 2022/9/21 10:44
 * Version 1.0
 **/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }

    @Test
    public void test(){
        int[] nums = {2,3,3,2};
        int i = removeElement(nums, 3);
        for (int j = 0; j < i; j++) {
            System.out.print(nums[j] + " ");
        }
    }
}
