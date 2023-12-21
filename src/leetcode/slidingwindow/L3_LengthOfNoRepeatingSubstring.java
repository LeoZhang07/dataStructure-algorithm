package leetcode.slidingwindow;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 3.无重复字符的最长子串 长度
 * 给定一个字符串 s ，找出其中不含有重复字符的 最长子串的长度。
 * @思路：滑动窗口
 * @过程：[i~cur) 作为窗口
 * i从0开始，只要cur位置不在set中，就往set中放；set的大小就是字串的长度，ans取其中的最大长度
 * 如果cur位置上的数在set中了，说明[i~cur）中有当前cur的数了，i++，左窗口慢慢往后滑动，直到排除掉重复的那个数之后，cur才继续++，右窗口往后滑动
 * @date 2023/10/28 21:11
 * @Copyright：treadstone.JasonBourne.com
 */
public class L3_LengthOfNoRepeatingSubstring {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            while (!set.contains(s.charAt(cur))) {
                set.add(s.charAt(cur));
                if (cur == s.length() - 1) {
                    ans = Math.max(cur + 1 - i, ans);
                    return ans;
                }
                cur++;
            }
            ans = Math.max(cur - i, ans);
            set.remove(s.charAt(i));
        }
        return ans;
    }

    @Test
    public void test() {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
