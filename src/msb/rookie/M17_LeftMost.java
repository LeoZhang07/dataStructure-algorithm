package msb.rookie;

import org.junit.Test;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 数组从小到大有序排列、找到>=num的最左边的数字
 * @思路：二分
 * @date 2023/10/24 10:24
 * @Copyright：treadstone.JasonBourne.com
 */
public class M17_LeftMost {
    public int findLeftMost(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 1, 2, 3, 4, 5, 5, 5, 6, 6, 7};
        System.out.println(findLeftMost(nums, 28));
    }
}
