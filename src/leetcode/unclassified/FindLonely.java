package leetcode.unclassified;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zkx
 * @ClassName FindLonely
 * @Description TODO leetcode 2150. 找出数组中的所有孤独数字
 * @Date 2022/8/19 14:15
 * Version 1.0
 **/
public class FindLonely {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);

        if (nums.length == 1){
            list.add(nums[0]);
            return list;
        }

        if (nums[1] - nums[0] > 1) {
            list.add(nums[0]);
        }
        if (nums[nums.length - 1] - nums[nums.length - 2] > 1) {
            list.add(nums[nums.length - 1]);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] - nums[i - 1] > 1 && nums[i + 1] - nums[i] > 1){
                list.add(nums[i]);
            }
        }

        return list;
    }

    @Test
    public void test() {
//        int[] ints = {10, 6, 5, 8};
//        int[] ints = {1,3,5,3};
        int[] ints = {0};
        System.out.println(findLonely(ints));
    }
}




