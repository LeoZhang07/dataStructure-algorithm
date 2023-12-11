package leetcode.stack;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author zkx
 * @ClassName IsValid
 * @Description TODO 20. 有效的括号
 * @Date 2022/9/19 16:02
 * Version 1.0
 * <p>
 * [(){()}]
 **/
public class IsValid {
    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (map.containsKey(stack.peek())) {
                return false;
            }
            if (stack.peek().equals(map.get(s.charAt(i)))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>(3);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (map.get(stack.peek()) == null) {
                return false;
            }
            if (map.get(stack.peek()).equals(s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test() {
//        System.out.println(isValid1("()"));
        System.out.println(isValid("()"));
    }
}
