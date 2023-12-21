package msb.system.xor;

import org.junit.Test;

import java.util.Arrays;

/*
 * 基本数据类型（如int）是按值传递
 * 对于对象引用类型（如自定义类的对象），情况会有所不同。如果你传递的是一个对象的引用，那么在方法内部更改该对象的状态会影响原始对象。
 * 不用多余内存交换两个数
 * */
public class SwapWithoutExtraVariable {
    public void swapWithExtraVariable(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public void swapWithoutExtraVariable(Integer a, Integer b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    @Test
    public void test1() {
        Integer a = 2;
        Integer b = 4;
        swapWithoutExtraVariable(a, b);
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void test2() {
        Integer a = 2;
        Integer b = 4;
        swapWithExtraVariable(a, b);
        System.out.println(a);
        System.out.println(b);
    }

    /*例子实际想要说明的主方法
     * a = 2;
     * b = 3;
     * a = a ^ b = 2 ^ 3;
     * b = a ^ b = 2 ^ (3 ^ 3) = 2;
     * a = a ^ b = 2 ^ 3 ^ 2 = (2 ^ 2) ^ 3 = 3;
     * */
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);

        //wrong example
        int[] arr = {3, 100};
        int i = 1;
        int j = 1;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        //Result of 'arr[i] ^ arr[j]' is always '0'
        //一定要不同内存位置的变量，否则会把自己刷成0
        System.out.println(Arrays.toString(arr));
    }
}
