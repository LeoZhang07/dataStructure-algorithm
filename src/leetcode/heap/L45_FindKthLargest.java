package leetcode.heap;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName FindKthLargest
 * @Description TODO 215. 数组中的第K个最大元素 medium 堆排序
 * @Date 2023/2/6 15:59
 * Version 1.0
 **/
public class L45_FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        //heapify构建堆
        int end = nums.length - 1;
        for (int i = (end - 1) / 2; i >= 0; i--) {
            heapify(i, nums, nums.length);
        }
        return nums[k - 1];
    }

    public void heapify(int index, int[] nums, int length) {
        int leftSon;
        int rightSon;
        int bigger;
        while (index * 2 + 1 < length) {
            leftSon = index * 2 + 1;
            rightSon = leftSon + 1;
            bigger = rightSon < length && nums[rightSon] > nums[leftSon] ? rightSon : leftSon;
            bigger = nums[bigger] > nums[index] ? bigger : index;
            if (bigger == index) {
                return;
            }
            swap(index, bigger, nums);
            index = bigger;
        }
    }

    public void swap(int x, int y, int[] arr) {
        int z = arr[x];
        arr[x] = arr[y];
        arr[y] = z;
    }

    @Test
    public void test() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }
}
