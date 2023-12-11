package huawei;

import org.junit.Test;

/**
 * @author leo
 * @version 1.0
 * @description: TODO leetcode 204. 计数质数 返回所有小于n的质数数量。n>0
 * @date 2023/10/31 23:19
 * @Copyright：treadstone.JasonBourne.com
 */
public class CountPrimes {
    public int countPrimes(int n) {
        //n<3的时候，没有质数
        if (n < 3) {
            return 0;
        }
        //n=3的时候，2是质数
        int count = 1;
        //i为偶一定不是质数
        for (int i = 3; i < n; i += 2) {
            boolean isPrime = true;
            //1.j最大遍历到根号n即可，因为如果i不是质数，那么它一定有一个因子是小于根号i的，如果两个因子都大于根号i，那么乘积一定大于i
            //2.i一定不为偶数，那么它的因子一定不是偶数
            for (int j = 3; j * j <= i; j += 2) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            //System.out.println(i);
            if (isPrime) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(countPrimes(5000000));
    }
}
