package msb.rookie;

import org.junit.Test;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 插入排序
 * @思路：从最小的区间开始，保证区间内绝对有序
 * @date 2023/10/23 13:13
 * @Copyright：treadstone.JasonBourne.com
 */
public class M7_InsertSort {
    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int current = i;
            while (current > 0 && nums[current] < nums[current - 1]) {
                swap(nums, current, current - 1);
                current--;
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
        insertSort(num);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
