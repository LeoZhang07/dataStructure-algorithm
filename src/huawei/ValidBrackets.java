package huawei;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author leo
 * @version 1.0
 * @description: TODO leetcode20 有效的括号
 * @date 2023/10/29 13:43
 * @Copyright：treadstone.JasonBourne.com
 */
public class ValidBrackets {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sCharArr = s.toCharArray();
        Map<Character, Character> map = initMap();
        for (int i = 0; i < sCharArr.length; i++) {
            if (stack.empty()) {
                stack.push(sCharArr[i]);
                continue;
            }
            if (map.get(stack.peek()) == null) {
                return false;
            }
            if (map.get(stack.peek()) == sCharArr[i]) {
                stack.pop();
            } else {
                stack.push(sCharArr[i]);
            }
        }
        return stack.empty() ? true : false;
    }

    public Map<Character, Character> initMap() {
        HashMap<Character, Character> map = new HashMap(3);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        return map;
    }

    @Test
    public void test() {
        String s = "([)]";
        System.out.println(isValid(s));
    }
}
