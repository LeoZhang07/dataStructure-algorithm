package LeetCode.unclassified;

import org.junit.Test;

import java.util.Map;
import java.util.Stack;

/**
 * @Author zkx
 * @ClassName LongestValidParentheses
 * @Description TODO 32. 最长有效括号(difficult)
 * @Date 2022/9/21 16:05
 * Version 1.0
 **/
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int l = 0;
        int r = 0;
        int maxLength1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                maxLength1 = Math.max(maxLength1, l + r);
            } else if (r > l) {
                l = 0;
                r = 0;
            }
        }
        l = 0;
        r = 0;
        int maxLength2 = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                r++;
            } else {
                l++;
            }
            if (l == r) {
                maxLength2 = Math.max(maxLength2, l + r);
            } else if (l > r) {
                l = 0;
                r = 0;
            }
        }
        return Math.max(maxLength1, maxLength2);
    }

    @Test
    public void test() {
        String s = "(()))())(";
        System.out.println(longestValidParentheses(s));
    }
}
