package huawei;

import org.junit.Test;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 二面
 * @date 2023/10/25 19:43
 * @Copyright：treadstone.JasonBourne.com
 */
public class SpinString {
//    旋转字符串
//
//    给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
//    s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
//    例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
//
//    示例 1:
//
//    输入: s = "abcde", goal = "cdeab"
//    输出: true
//    示例 2:
//
//    输入: s = "abcde", goal = "abced"
//    输出: false
//
//    提示:
//            •	1 <= s.length, goal.length <= 100
//            •	s 和 goal 由小写英文字母组成

    public boolean rotateString(String s, String goal){

        String newS = s;
        for (int i = 0; i < s.length(); i++) {
            if (newS.equals(goal)) {
                return true;
            }
            newS = spin(newS);
        }
        return false;
    }

    public String spin(String s) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 1; i < s.length(); i++) {
            buffer.append(s.charAt(i));
        }
        StringBuffer stringBuffer = buffer.append(s.charAt(0));
        return stringBuffer.toString();
    }

    String s = "a";
    String goal = "a";

    @Test
    public void test() {
        System.out.println(rotateString(s, goal));
    }
}
