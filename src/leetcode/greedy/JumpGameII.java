package leetcode.greedy;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 45. 跳跃游戏 II
 * border是每一步范围内的最大边界
 * 每次碰到border的时候，一定会往下走一步，所以step++
 * 但是要避免走到最后一个元素，因为前一步一定会走到最后一个元素
 * @date 2024/2/28 16:47
 * @Copyright：treadstone.JasonBourne.com
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int steps = 0;
        int border = 0;
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == border) {
                border = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
