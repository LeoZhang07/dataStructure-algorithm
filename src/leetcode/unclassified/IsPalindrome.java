package leetcode.unclassified;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName IsPalindrome
 * @Description TODO 9. 回文数
 * @Date 2022/9/14 9:27
 * Version 1.0
 **/
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        //负数或者个位为0的数不可能回文
        if (x < 0) {
            return false;
        }
        if (x > 0 && x % 10 == 0) {
            return false;
        }
        //翻转一半
        int y = 0;
        while (x > y) {
            y = y * 10 + (x % 10);
            x = x / 10;
        }
        if (y > x){
            y = y / 10;
        }
        if (x == y) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test(){
        System.out.println(isPalindrome(121));
    }
}
