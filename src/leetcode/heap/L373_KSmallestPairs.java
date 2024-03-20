package leetcode.heap;

import org.junit.Test;

import java.util.*;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 查找和最小的 K 对数字
 * @date 2024/3/18 11:57
 * @Copyright：treadstone.JasonBourne.com
 */

/*
题解：
类似于L23，合并k个升序链表，每次从头链表中取到最小到那个节点
那么类似的，这个题中比如：
nums1:【1，7，11，16】
nums2:【2，9，10，15】
做n*n之后，可以得到如下的结构：
(1,2)  ->  (1,9) -> (1,10)  -> (1,15)
(7,2)  ->  (7,9) -> (7,10)  -> (7.15)
(11,2) -> (11,9) -> (11,10) -> (16,15)
(16,2) -> (16,9) -> (16,10) -> (16,15)
每次只拿最小的头部元素即可
 */
public class L373_KSmallestPairs {
    //数组下标pair
    class NumberPair {
        int num1_p;
        int num2_p;

        public NumberPair(int num1_p, int num2_p) {
            this.num1_p = num1_p;
            this.num2_p = num2_p;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<NumberPair> priorityQueue = new PriorityQueue<>(k, (Comparator.comparingInt(o -> (nums1[o.num1_p] + nums2[o.num2_p]))));

        for (int i = 0; i < nums1.length; i++) {
            priorityQueue.offer(new NumberPair(i, 0));
        }
        //只需要调整k次，找k次最小元素进入ans里即可
        while (k-- > 0 && !priorityQueue.isEmpty()) {
            NumberPair minPair = priorityQueue.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[minPair.num1_p]);
            list.add(nums2[minPair.num2_p]);
            ans.add(list);
            if (minPair.num2_p + 1 < nums2.length) {
                priorityQueue.offer(new NumberPair(minPair.num1_p, minPair.num2_p + 1));
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        kSmallestPairs(nums1, nums2, 3);
    }
}
