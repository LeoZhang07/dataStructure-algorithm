package leetcode.string;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName LengthOfLastWord
 * @Description TODO 58. 最后一个单词的长度 easy
 * @Date 2023/2/1 16:09
 * Version 1.0
 **/
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

    @Test
    public void test() {
        String s = "a ";
        System.out.println(lengthOfLastWord(s));
    }
}
