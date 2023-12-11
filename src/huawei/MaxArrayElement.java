package huawei;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 查找一个数组中出现次数最多的值，如果存在相同数量按大的值输出
 * @date 2023/10/28 21:50
 * @Copyright：treadstone.JasonBourne.com
 */
public class MaxArrayElement {
    public int maxArrayElement(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        int maxCount = Integer.MIN_VALUE;

        for (int element : arr) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }

            if (map.get(element) > maxCount) {
                ans = element;
                maxCount = map.get(element);
            }
            if (map.get(element) == maxCount) {
                ans = Math.max(element, ans);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] arr = {1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4};
        System.out.println(maxArrayElement(arr));
    }
}
