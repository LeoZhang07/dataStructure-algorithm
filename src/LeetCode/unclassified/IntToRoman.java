package LeetCode.unclassified;

/**
 * @Author zkx
 * @ClassName IntToRoman
 * @Description TODO 12.
 * @Date 2022/9/14 15:20
 * Version 1.0
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 **/
public class IntToRoman {
    public String intToRoman(int num) {
        return null;
    }

    public String intToRoman1(int num) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symble = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                num = num - value[i];
                ans.append(symble[i]);
            }
        }
        return ans.toString();
    }

    public String intToRoman2(int num) {
        return null;
    }


}
