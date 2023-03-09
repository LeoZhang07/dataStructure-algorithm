package msb.rookie.sort;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName SelectionSort
 * @Description TODO 选择排序
 * @Date 2022/10/26 18:40
 * Version 1.0
 **/
public class SelectionSort {
    public int[] selectionSort(int[] num) {
        if (num == null || num.length < 2) {
            return num;
        }
        int temp;
        for (int i = 0; i < num.length; i++) {
            int min = num[i];
            int minIndex = i;
            for (int j = i; j < num.length; j++) {
                if (num[j] < min) {
                    min = num[j];
                    minIndex = j;
                }
            }
                temp = num[i];
                num[i] = min;
                num[minIndex] = temp;

        }
        return num;
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
