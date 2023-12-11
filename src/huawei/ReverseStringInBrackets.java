package huawei;

import org.junit.Test;

import java.util.Stack;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 反转每对括号间的子串
 * @思路：翻转括号内的字符串相当于逆序遍历括号内的内容 遍历字符串：
 * https://www.bilibili.com/video/BV1Cb4y1S7G8/?spm_id_from=333.337.search-card.all.click&vd_source=72037f2042f3e8fc6f656fe5933cc2ac
 * 1.遇到普通字符则加进str中。
 * 2.遇到左括号，说明左括号右边的需要被翻转了，而左括号左边的元素不动，则把左边的元素进栈暂存，即str中保存的数暂存进栈中，留到后面弹出，并加在字符串左边。
 * 2.遇到右括号，说明要把括号内的内容翻转了，这时候括号内的内容就是str中的内容，翻转str，并取出暂存在栈中的内容，加在字符串左边。
 * @date 2023/10/29 15:10
 * @Copyright：treadstone.JasonBourne.com
 */
public class ReverseStringInBrackets {
    public String reverseParentheses(String s) {
        String str = "";
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                stack.push(str);
                str = "";
                i++;
                while (s.charAt(i) != ')' && s.charAt(i) != '(') {
                    str = str + s.charAt(i);
                    i++;
                }
                continue;
            }
            if (s.charAt(i) == ')') {
                String pop = stack.peek() == null ? "" : stack.pop();
                String reverse = "";
                for (int j = str.length() - 1; j >= 0; j--) {
                    reverse = reverse + str.charAt(j);
                }
                str = pop + reverse;
                i++;
                continue;
            }
            //普通字母则直接加进str中
            str = str + s.charAt(i);
            i++;
        }
        return str;
    }

    @Test
    public void test() {
        String s = "(u(love)i)";
        System.out.println(reverseParentheses(s));
    }
}
