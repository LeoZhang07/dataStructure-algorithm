package msb.system.xor;

/**
 * @author leo
 * @version 1.0
 * @description: TODO leetcode 136. 只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * 或者说
 * 只有一个元素出现奇数次，其余每个元素均出现偶数次。找出那个奇数次的元素
 * @date 2023/12/21
 * @Copyright：treadstone.JasonBourne.com
 */
public class L136_SingleNumber {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        return xor;
    }
}
