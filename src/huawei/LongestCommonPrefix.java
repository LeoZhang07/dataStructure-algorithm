package huawei;

/**
 * @author leo
 * @version 1.0
 * @description: TODO
 * @date 2023/11/1 00:53
 * @Copyright：treadstone.JasonBourne.com
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        String basicStr = "";
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
                basicStr = str;
            }
        }
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < basicStr.length(); i++) {
            for (String str : strs) {
                if (str.charAt(i) != basicStr.charAt(i)) {
                    return buffer.toString();
                }
            }
            buffer.append(basicStr.charAt(i));
        }

        return buffer.toString();
    }
}
