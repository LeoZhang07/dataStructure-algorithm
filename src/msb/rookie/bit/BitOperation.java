package msb.rookie.bit;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName BitOperation
 * @Description TODO 打印一个整形数字
 * @Date 2022/7/28 17:47
 * Version 1.0
 **/
public class BitOperation {
    public void myPrint(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
    }

    @Test
    public void test(){
        myPrint(3);
        myPrint(~Integer.MIN_VALUE);
        System.out.println();
        System.out.println();
    }
}
