package LeetCode.unclassified;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zkx
 * @ClassName RomanToInt
 * @Description TODO 13. 罗马数字转整数
 * @Date 2022/9/14 16:30
 * Version 1.0
 *
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 **/
public class RomanToInt {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>(7);
        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);
        if (s.length() == 1){
            return map.get(s.charAt(0));
        }
        int ans = 0;
        char currentLetter;
        int currentValue;
        for (int i = 0; i < s.length() - 1 ; i++) {
            currentLetter = s.charAt(i);
            currentValue = map.get(currentLetter);
            if (currentValue < map.get(s.charAt(i + 1))){
                ans = ans - currentValue;
            } else {
                ans = ans + currentValue;
            }
        }
        return ans + map.get(s.charAt(s.length() - 1));
    }

    @Test
    public void test(){
        String s = "III";
        System.out.println(romanToInt(s));
    }
}
