package huawei;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.SortedMap;

/**
 * @author leo
 * @version 1.0
 * @description: TODO
 * 给定一个整数数组 temperatures ，表示每天的温度，
 * 返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * <p>
 * 单调栈
 * @date 2023/11/4 10:24
 * @Copyright：treadstone.JasonBourne.com
 */
public class Temper {
    public int[] geTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length - 1; i++) {
            int cur = ans[i];
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
            ans[i] = ans[i] == cur ? 0 : ans[i];
        }
        return ans;
    }

    @Test
    public void test() {
        int[] param = {30, 60, 90};
        System.out.println(Arrays.toString(geTemperatures(param)));
    }

}
