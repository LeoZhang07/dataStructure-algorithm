package huawei.computerTest;

import java.util.*;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 阿里巴巴找黄金宝箱III
 * @date 2023/10/15 15:26
 * @Copyright：treadstone.JasonBourne.com
 */
public class AlbbFindGodenBoxIII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //第一行
        String[] strArr = in.nextLine().split(",");
        int[] boxes = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            boxes[i] = Integer.parseInt(strArr[i]);
        }
        //第二行
        int num = in.nextInt();
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < boxes.length; i++) {
            if (numMap.containsKey(boxes[i])) {
                if (i - numMap.get(boxes[i]) <= num) {
                    System.out.println(numMap.get(boxes[i]));
                    return;
                } else {
                    numMap.put(boxes[i], i);
                }
            } else {
                numMap.put(boxes[i], i);
            }
        }
        System.out.println(-1);
    }
}
