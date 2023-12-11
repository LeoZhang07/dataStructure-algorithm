package leetcode.search;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName SearchRange
 * @Description TODO 34. 在排序数组中查找元素的第一个和最后一个位置(medium)
 * @Date 2022/10/17 10:54
 * Version 1.0
 **/
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            int m;
            int[] ans = {-1, -1};
            while (l <= r) {
                m = (l + r) / 2;
                if (target == nums[m]) {
                    for (int i = m; i >= 0; i--) {
                        if (nums[i] != target) {
                            ans[0] = ++i;
                            break;
                        }
                        if (i == 0 && nums[i] == target) {
                            ans[0] = 0;
                        }
                    }
                    for (int i = m; i < nums.length; i++) {
                        if (nums[i] != target) {
                            ans[1] = --i;
                            break;
                        }
                        if (i == nums.length - 1 && nums[i] == target) {
                            ans[1] = nums.length - 1;
                        }
                    }
                    return ans;
                } else if (target < nums[m]) {
                    r = m;
                    if ((r - l) <= 1) {
                        if ((nums[l] == target)) {
                            ans[0] = l;
                            ans[1] = l;
                            return ans;
                        } else {
                            break;
                        }
                    }
                } else {
                    l = m;
                    if ((r - l) <= 1) {
                        if ((nums[r] == target)) {
                            ans[0] = r;
                            ans[1] = r;
                            return ans;
                        } else {
                            break;
                        }
                    }
                }
            }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        int[] ints = searchRange(nums, 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
