package msb.rookie.sort;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName InsertSort
 * @Description TODO 插入排序
 * @Date 2022/10/27 19:44
 * Version 1.0
 **/
public class InsertSort {
    public void insertSort(int[] nums) {
        int curr;
        int temp;
        for (int i = 1; i < nums.length; i++) {
            curr = i;
            while ((curr - 1) >= 0 && nums[curr - 1] > nums[curr]) {
                temp = nums[curr];
                nums[curr] = nums[curr - 1];
                nums[curr - 1] = temp;
                curr--;
            }
        }
    }

    public void betterInsertSort(int[] nums) {
        int curr;
        int temp;
        for (int i = 1; i < nums.length; i++) {
            curr = i;
            for (int j = curr - 1; j >= 0 && nums[j] > nums[j + 1]; j--) {
                temp = nums[curr];
                nums[curr] = nums[curr - 1];
                nums[curr - 1] = temp;
            }
        }
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
