package msb.rookie;

import org.junit.Test;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 阶乘相加
 * @思路： 记录用上一步的阶乘结果，用于下一步的计算
 * @date 2023/10/18 14:08
 * @Copyright：treadstone.JasonBourne.com
 */
public class M4_FactorialAddition {
    public long factorialAddition(int n) {
        long ans = 0;
        long cur = 1;
        for (int i = 1; i <= n; i++) {
            cur = cur * i;
            ans += cur;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(factorialAddition(10));
    }
}
