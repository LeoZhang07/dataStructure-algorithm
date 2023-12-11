package msb.rookie;

import org.junit.Test;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 冒泡
 * @思路： 两两比较，每次循环一定是把最小的放在最前面
 * @date 2023/10/23 12:18
 * @Copyright：treadstone.JasonBourne.com
 */
public class Q6_BubbleSort {
    public void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void test() {
        int[] num = {1, 1, 1, 7, 6, 6, 5, 5, 5, 4, 3, 2, 1};
        bubbleSort(num);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
