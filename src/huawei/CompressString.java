package huawei;

import org.junit.Test;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 压缩字符串
 * @date 2023/10/24 16:34
 * @Copyright：treadstone.JasonBourne.com
 */
public class CompressString {
    public String compressString(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String str = s.concat("!");
        char[] chars = str.toCharArray();
        StringBuffer buffer = new StringBuffer();
        int cur = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[cur] != chars[i]) {
                buffer.append(chars[cur]);
                String count = new Integer(i - cur).toString();
                buffer.append(count);
                cur = i;
            }
        }
        String compressed = buffer.toString();
        return compressed.length() <= s.length() ? compressed : s;
    }

    @Test
    public void test() {
        String s1 = "aabcccccaaa";
        System.out.println(compressString(s1));
        String s2 = "abcde";
        System.out.println(compressString(s2));
    }
}
