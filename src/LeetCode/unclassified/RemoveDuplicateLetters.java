package LeetCode.unclassified;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author zkx
 * @ClassName RemoveDuplicateLetters
 * @Description TODO 力扣 316. 去除重复字母
 * @Date 2022/8/11 15:12
 * Version 1.0
 **/
public class RemoveDuplicateLetters {
    /**
     * 记录字符是否在栈中出现：true|出现；false|未出现
     */
    boolean[] vis = new boolean[26];

    /**
     * 记算每一种字符在剩下的字符串中还剩几个
     */
    int[] count = new int[26];

    Stack<Character> stack = new Stack<>();

    public String removeDuplicateLetters(String s) {
        // 第 1 步：记录每个元素都有几个
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // 第 2 步：使用栈得到题目要求字典序最小的字符串栈
        Stack<Character> subStringStack = getSubStringStack(s);

        //第 3 步：此时 stack 就是题目要求字典序最小的字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : subStringStack) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    /**
     * getSubStringStack
     * Todo: 得到字典序最小的字符串
     *
     * @param s
     * @return 最小的字符串栈
     */
    public Stack<Character> getSubStringStack(String s) {
        Character stackPeek; //栈顶元素
        char current; //当前元素

        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            //栈空则直接压入
            if (stack.empty()) {
                stack.push(current);
                vis[current - 'a'] = true;
                count[current - 'a']--;
                continue;
            }

            stackPeek = getPeek(stack);

            //栈中没有当前元素
            if (!vis[current - 'a']) {
                //符合如下条件,出栈：栈顶>当前，且后面还有栈顶元素
                // (stackPeek > current && count[stackPeek - 'a'] > 0)
                while (stackPeek != null && stackPeek > current && count[stackPeek - 'a'] > 0) {
                    vis[stack.pop() - 'a'] = false;
                    stackPeek = getPeek(stack);
                }
                stack.push(current);
                vis[current - 'a'] = true;
            }
            //入栈的和没入栈的，都相当于后面的元素中少了一个
            count[current - 'a']--;
        }
        return stack;
    }

    public Character getPeek(Stack<Character> stack) {
        try {
            return stack.peek();
        } catch (Exception e) {
            return null;
        }
    }

    @Test
    public void thisTest() {
        String s = "abbbba";
        System.out.println(removeDuplicateLetters(s));
    }
}
