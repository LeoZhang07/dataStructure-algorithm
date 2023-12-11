package leetcode.string;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName IsAnagram
 * @Description TODO 242. 有效的字母异位词 easy
 * s 和 t 仅包含小写字母
 * <p>
 * a-z 的ASCII 【97,122】
 * @Date 2023/2/1 16:59
 * Version 1.0
 **/
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i) - 97]++;
        }
        for (int i = 0; i < t.length(); i++) {
            tArr[t.charAt(i) - 97]++;
        }
        for (int i = 0; i < 26; i++) {
            if (sArr[i] != tArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
