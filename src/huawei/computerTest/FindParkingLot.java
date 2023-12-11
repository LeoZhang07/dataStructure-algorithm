package huawei.computerTest;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 华为找车位问题
 * @date 2023/10/15 14:36
 * @Copyright：treadstone.JasonBourne.com
 */
public class FindParkingLot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        //半角逗号分隔
        String[] stringNums = input.split(",");
        //转换成整形数组
        int[] numArr = new int[stringNums.length];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(stringNums[i]);
        }
        //找到所有为1的停车位
        ArrayList<Integer> idx = new ArrayList<>();
        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i] == 1) {
                idx.add(i);
            }
        }
        if (idx.size() == 0) {
            System.out.println(numArr.length - 1);
        } else {
            int result = 0;
            int r = numArr.length - 1;
            //最左边或者最右边没车
            if (idx.get(0) != 0 || idx.get(idx.size() - 1) != r) {
                result = Math.max(idx.get(0), r - idx.get(idx.size() - 1));
            }

            for (int i = 1; i < idx.size(); i++) {
                result = Math.max(result, (idx.get(i) - idx.get(i - 1)) / 2);
            }
            System.out.println(result);
        }
    }
}
