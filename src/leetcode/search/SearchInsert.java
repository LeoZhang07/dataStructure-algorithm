package leetcode.search;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName SearchInsert
 * @Description TODO 35. 搜索插入位置(easy)
 * @Date 2022/10/17 10:10
 * Version 1.0
 **/
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int m;
        while (r - l > 1) {
            m = (l + r) /2;
            if (target == nums[m]) {
                return m;
            } else if (target < nums[m]) {
                r = m;
            }else {
                l = m;
            }
        }
        if (target > nums[l]){
            if (target < nums[r]){
                return l + 1;
            }else if (target == nums[r]){
                return r;
            }else {
                return r + 1;
            }
        }else {
            return 0;
        }
    }

    @Test
    public void test(){
        int[] nums = {1,3};
        System.out.println(searchInsert(nums, 3));
    }
}
