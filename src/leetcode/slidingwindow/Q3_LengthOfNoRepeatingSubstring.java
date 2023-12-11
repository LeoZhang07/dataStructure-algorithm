package leetcode.slidingwindow;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 3.无重复字符的最长子串
 * 给定一个字符串 s ，找出其中不含有重复字符的 最长子串 的长度。
 * @思路：滑动窗口
 * @date 2023/10/28 21:11
 * @Copyright：treadstone.JasonBourne.com
 */
public class Q3_LengthOfNoRepeatingSubstring {
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
