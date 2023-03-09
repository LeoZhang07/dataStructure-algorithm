package msb.rookie;

import org.junit.Test;

/**
 * @Author zkx
 * @ClassName Random
 * @Description TODO
 * @Date 2022/10/28 14:55
 * Version 1.0
 **/
public class Random {
    int testTimes = 1000000;

    public double m(double x) {
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.max(Math.random(), Math.random()) <= x) {
                count++;
            }
        }
        return (double) count / (double) testTimes;
    }

    @Test
    public void test() {
        System.out.println(m(0.95));
    }
}
