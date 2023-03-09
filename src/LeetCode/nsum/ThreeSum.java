package LeetCode.nsum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zkx
 * @ClassName ThreeSum
 * @Description TODO
 * @Date 2022/9/15 15:22
 * Version 1.0
 * 输入：
 * [3,0,-2,-1,1,2]
 * 输出：
 * [[-2,-1,3],[-2,0,2]]
 * 预期结果：
 * [[-2,-1,3],[-2,0,2],[-1,0,1]]
 **/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int a = 0; a < nums.length - 2; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            int c = nums.length - 1;
            for (int b = a + 1; b < nums.length - 1; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                while (b < c) {
                    if (nums[a] + nums[b] + nums[c] < 0) {
                        break;
                    }
                    while (b < c && nums[a] + nums[b] + nums[c] > 0) {
                        c--;
                    }
                    if (b < c && nums[a] + nums[b] + nums[c] == 0) {
                        List<Integer> subList = new ArrayList<>();
                        subList.add(nums[a]);
                        subList.add(nums[b]);
                        subList.add(nums[c]);
                        list.add(subList);
                        break;
                    }
                }
            }
        }

        return list;
    }


    @Test
    public void test() {
        int[] nums = new int[]{-2, -1, 0, 1, 2, 3};
        int[] nums1 = new int[]{-1, -1, 0, 1, 1, 2};
        int[] nums2 = new int[]{1, 2, -2, -1};
        System.out.println(threeSum(nums2));
    }
}
