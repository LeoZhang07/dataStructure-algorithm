package leetcode.string;


/**
 * @Author zkx
 * @ClassName ToLowerCase
 * @Description TODO 709. 转换成小写字母 easy
 *
 *
 * A-Z 的ASCII 【65,90】+ 32即可
 * a-z 的ASCII 【97,122】
 *
 * 对于从65：到 90：中的所有数，表示32的进制位都是0，因此可以对ch的ASCII码做[或运算]，代替加32运算
 * 01000001
 * 01011010
 * 00100000
 *
 *
 * @Date 2023/2/1 15:33
 * Version 1.0
 **/
public class ToLowerCase {
//    public String toLowerCase(String s) {
//        return s.toLowerCase();
//    }
    char c;
    public String toLowerCase(String s) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c >= 65 && c <= 90) {
                c |= 32;
            }
            sBuilder.append(c);
        }
        return sBuilder.toString();
    }
}
