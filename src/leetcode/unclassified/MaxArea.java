package leetcode.unclassified;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName MaxArea
 * @Description TODO 11. 盛最多水的容器
 * @Date 2022/8/25 15:26
 * Version 1.0
 **/
public class MaxArea {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int curArea;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            curArea = (right - left) * Math.min(height[left], height[right]);
            if(maxArea < curArea){
                maxArea = curArea;
            }
            if (height[left] <= height[right] ) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    @Test
    public void test() {
        int[] ints = {1, 1};
        System.out.println(maxArea(ints));
    }
}
