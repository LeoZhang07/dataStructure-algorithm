package msb.rookie.sort;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName BubbleSort
 * @Description TODO
 * @Date 2022/10/27 14:54
 * Version 1.0
 **/
public class BubbleSort {
    public void bubbleSort(int[] nums) {
        int temp;
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
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
