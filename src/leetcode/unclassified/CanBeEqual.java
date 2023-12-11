package leetcode.unclassified;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName CanBeEqual
 * @Description TODO
 * @Date 2022/8/24 16:16
 * Version 1.0
 **/
public class CanBeEqual {
    //[3,7,9]
    //[3,7,11]
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] a = new int[1001];
        int[] b = new int[1001];

        for (int i = 0; i < target.length; i++) {
            ++a[target[i]];
        }
        for (int i = 0; i < target.length; i++) {
            ++b[arr[i]];
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        int[] target = new int[]{3,7,9};
        int[] arr = new int[]{3,7,11};
        System.out.println(canBeEqual(target,arr));
    }
}
