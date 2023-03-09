package LeetCode.nsum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zkx
 * @ClassName FourSum
 * @Description TODO
 * @Date 2022/9/19 10:41
 * Version 1.0
 **/
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);
        int d;
        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            if ((long) nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) {
                break;
            }
            if ((long) nums[a] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                if ((long) nums[a] + nums[b] + nums[b + 1] + nums[b + 2] > target) {
                    break;
                }
                if ((long) nums[a] + nums[b] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }
                d = nums.length - 1;
                for (int c = b + 1; c < nums.length - 1; c++) {
                    if (c > b + 1 && nums[c] == nums[c - 1]) {
                        continue;
                    }
                    while (c < d) {
                        if ((long) nums[a] + nums[b] + nums[c] + nums[d] == target) {
                            ArrayList<Integer> subList = new ArrayList<>();
                            subList.add(nums[a]);
                            subList.add(nums[b]);
                            subList.add(nums[c]);
                            subList.add(nums[d]);
                            list.add(subList);
                            break;
                        }
                        if ((long) nums[a] + nums[b] + nums[c] + nums[d] < target) {
                            break;
                        }
                        while (c < d && (long) nums[a] + nums[b] + nums[c] + nums[d] > target) {
                            d--;
                        }
                    }

                }
            }
        }
        return list;
    }

    /*
    *
    *
    *  输入：
[1,0,-1,0,-2,2]
0
输出：
[[-2,-1,1,1],[-2,0,0,0],[-1,0,0,0]]
预期结果：
[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    * */
    @Test
    public void test() {
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        System.out.println(fourSum(nums, -294967296));

        System.out.println(1000000000 + 1000000000);
        System.out.println(Integer.MIN_VALUE);
    }
}
