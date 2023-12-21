package msb.rookie;

import org.junit.Test;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 选择排序
 * @思路： 遍历数组，每次选最小的往最前面放
 * @date 2023/10/18 14:24
 * @Copyright：treadstone.JasonBourne.com
 */
public class M5_SelectionSort {
    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minValueIndex = i;
            int minVal = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < minVal) {
                    minVal = nums[j];
                    minValueIndex = j;
                }
            }
            swap(nums,i,minValueIndex);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int[] num = {1, 1, 1, 7, 6, 6, 5, 5, 5, 4, 3, 2, 1};
        selectionSort(num);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
