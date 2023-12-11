package leetcode.nsum;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author zkx
 * @ClassName ThreeSumClosest
 * @Description TODO
 * @Date 2022/9/16 14:03
 * Version 1.0
 **/
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int sum;
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
                    sum = nums[a] + nums[b] + nums[c];
                    ans = Math.abs(ans - target) < Math.abs(sum - target) ? ans : sum;
                    if (sum - target < 0) {
                        break;
                    }
                    while (b < c && nums[a] + nums[b] + nums[c] - target > 0) {
                        c--;
                    }
                    if (b < c && nums[a] + nums[b] + nums[c] - target == 0) {
                        return nums[a] + nums[b] + nums[c];
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
/*        int[] nums = {-987, -981, -968, -959, -950, -943, -942, -941, -935, -931, -897, -882, -854, -852, -848, -844, -840, -826, -825, -816};
        for (int a = 0; a < nums.length - 2; a++) {
            for (int b = a + 1; b < nums.length - 1; b++) {
                for (int c = b + 1; c < nums.length; c++) {
                    if (nums[a] + nums[b] + nums[c] == -2805) {
                        System.out.println(nums[a]);
                        System.out.println(nums[b]);
                        System.out.println(nums[c]);
                    }
                }
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d,", nums[i]);
        }
        System.out.println();
        int target = -2805;
        System.out.println(threeSumClosest(nums, target));*/
        System.out.println(threeSumClosest(new int[]{-4, -1, 1, 2}, 1));
    }


}
