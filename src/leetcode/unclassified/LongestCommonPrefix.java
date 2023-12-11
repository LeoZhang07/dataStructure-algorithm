package leetcode.unclassified;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName LongestCommonPrefix
 * @Description TODO
 * @Date 2022/9/15 10:48
 * Version 1.0
 **/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 1) {
            return strs[0];
        }
        String ans = strs[0];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < strs.length; i++) {
            if (ans.length() <= strs[i].length()) {
                for (int j = 0; j < ans.length(); j++) {
                    if (ans.charAt(j) == strs[i].charAt(j)) {
                        stringBuffer.append(ans.charAt(j));
                    }else {
                        break;
                    }
                }
                ans = stringBuffer.toString();
                stringBuffer.setLength(0);
            } else {
                for (int j = 0; j < strs[i].length(); j++) {
                    if (ans.charAt(j) == strs[i].charAt(j)) {
                        stringBuffer.append(ans.charAt(j));
                    }else {
                        break;
                    }
                }
                ans = stringBuffer.toString();
                stringBuffer.setLength(0);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        String[] strs = new String[]{"cir","car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
