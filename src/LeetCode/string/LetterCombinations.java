package LeetCode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zkx
 * @ClassName LetterCombinations
 * @Description TODO 17. 电话号码的字母组合(medium)
 * @Date 2022/9/23 11:12
 * Version 1.0
 **/
public class LetterCombinations {
    Map<Character, String> map = new HashMap<Character, String>(9) {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    StringBuffer sb = new StringBuffer();

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        dig(list, digits, 0);
        return list;
    }

    public void dig(List<String> list, String digits, int index) {
        if (index == digits.length()) {
            list.add(sb.toString());
        } else {
            //map.get(digits.charAt(index));获取当前数字代表的所有字符
            for (int i = 0; i < map.get(digits.charAt(index)).length(); i++) {
                sb.append(map.get(digits.charAt(index)).charAt(i));
                dig(list, digits, index + 1);
                sb.deleteCharAt(index);
            }
        }
    }

    StringBuffer sb1 = new StringBuffer();
    @Test
    public void test() {
        System.out.println(letterCombinations(""));

        //System.out.println("".length());
        List<String> list = new ArrayList<>();
        list.add(sb1.toString());
        System.out.println(list.toString());
    }
}
