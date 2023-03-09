package LeetCode.unclassified;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName Reverse
 * @Description TODO 7. 整数反转
 * @Date 2022/9/8 16:41
 * Version 1.0
 **/
public class Reverse {
    public int reverse(int x) {
        int rev = 0;
        int temp;
        while (x != 0) {
            if(rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10){
                return 0;
            }
            temp = x % 10;
            x = x / 10;
            rev = rev * 10 + temp;
        }
        return rev;
    }

    @Test
    public void test(){
        System.out.println(reverse(1534236469));
    }
}
