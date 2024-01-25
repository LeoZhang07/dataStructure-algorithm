package leetcode.unclassified;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 1200. 最小绝对差 按升序返回
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * @date 2024/1/11 11:29
 * @Copyright：treadstone.JasonBourne.com
 */
public class L1200_MinAbsDiff {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int minAbsDif = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int difference = arr[i + 1] - arr[i];
            if (difference < minAbsDif) {
                minAbsDif = difference;
                ans.clear();
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                ans.add(list);
            } else if (difference == minAbsDif) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                ans.add(list);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] arr = {4, 2, 1, 3};
        System.out.println(minimumAbsDifference(arr));
    }
}
