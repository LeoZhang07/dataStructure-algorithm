package LeetCode.string;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName IsPalindrome
 * @Description TODO easy
 * 字母和数字都属于字母数字字符。
 * @Date 2023/2/3 9:28
 * Version 1.0
 **/
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (!Character.isLetterOrDigit(s.charAt(l)) && l < r) {
                l++;
            }
            while (!Character.isLetterOrDigit(s.charAt(r)) && l < r) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    @Test
    public void test() {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(s.toLowerCase());
    }
}
