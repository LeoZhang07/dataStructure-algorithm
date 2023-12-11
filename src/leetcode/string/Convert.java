package leetcode.string;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName Convert
 * @Description TODO 6.Z字形变换(medium)
 * @Date 2022/9/22 14:23
 * Version 1.0
 **/
public class Convert {
    public String convert(String s, int numRows) {
        if (s.length() < numRows || numRows == 1) {
            return s;
        }
        //周期
        int t = 2 * numRows - 2;
        int length = s.length();
        StringBuffer sb = new StringBuffer();
        int j = 0;
        while (j < length) {
            sb.append(s.charAt(j));
            j = j + t;
        }
        for (int i = 1; i < numRows - 1; i++) {
            j = i;
            while (j < length) {
                sb.append(s.charAt(j));
                j = j + t - 2 * i;
                if (j < length) {
                    sb.append(s.charAt(j));
                    j = j + 2 * i;
                }
            }
        }
        j = numRows - 1;
        while (j < length) {
            sb.append(s.charAt(j));
            j = j + t;
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String s = "ABABABABAB";
        System.out.println(convert(s, 2));
    }
}