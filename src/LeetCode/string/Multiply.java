package LeetCode.string;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.junit.Test;

/**
 * @Author zkx
 * @ClassName Multiply
 * @Description TODO 43. 字符串相乘
 * @Date 2022/10/21 10:46
 * Version 1.0
 **/
public class Multiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] = ansArr[i] % 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer sb = new StringBuffer();
        while (index < m + n) {
            sb.append(ansArr[index]);
            index++;
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(multiply("9133", "0"));
    }
}
