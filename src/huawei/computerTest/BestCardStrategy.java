package huawei.computerTest;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 最佳的出牌方法
 * @date 2023/10/15 15:51
 * @Copyright：treadstone.JasonBourne.com
 */
public class BestCardStrategy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cards = scanner.nextLine();
        //init card map
        HashMap<Integer, Integer> cardMap = new HashMap<>();
        for (int i = 1; i <= 13; i++) {
            cardMap.put(i, 0);
        }
        //计算每张牌的数量
        for (int i = 0; i < cards.length(); i++) {
            char c = cards.charAt(i);
            //10为数字0
            if (c == '0') {
                cardMap.put(10, cardMap.get(10) + 1);
            } else if (c == 'J') {
                cardMap.put(11, cardMap.get(11) + 1);
            } else if (c == 'Q') {
                cardMap.put(12, cardMap.get(12) + 1);
            } else if (c == 'K') {
                cardMap.put(13, cardMap.get(13) + 1);
            } else {
                cardMap.put(c - '0', cardMap.get(c - '0') + 1);
            }
        }

        int ans = 0;

        //顺子
        while (true) {
            int max = 0;
            int l = 0;
            int p = 1;
            while (true) {
                if (p >= 10) {
                    break;
                }
                int flushVal = calculateFlush(cardMap, p);
                if (flushVal > max) {
                    max = flushVal;
                    l = p;
                }
                p++;
            }
            if (l == 0) {
                break;
            }
            for (int i = l; i < l + 4; i++) {
                ans = ans + i * 2;
                cardMap.put(ans,cardMap.get(i) - 1);
            }
        }

        for (int i = 1; i <= 13; i++) {
            if (cardMap.get(i) == 1) {
                ans = ans + i;
            } else if (cardMap.get(i) == 3 || cardMap.get(i) == 2) {
                ans = ans + i * cardMap.get(i) * 2;
            } else if (cardMap.get(i) == 4) {
                ans = ans + cardMap.get(i) * 3;
            }
        }

        System.out.println(ans);
    }

    //计算顺子价值
    public static int calculateFlush(HashMap<Integer, Integer> cardMap, int idx) {
        int value = 0;
        for (int i = idx; i <= idx + 4; i++) {
            //10以上不能成顺
            if (cardMap.get(i) == 0) {
                return Integer.MIN_VALUE;
            } else if (cardMap.get(i) == 1) {
                value = value + i;
            } else if (cardMap.get(i) == 2) {
                value = value - i;
            } else if (cardMap.get(i) == 4) {
                value = value - i * 4;
            }
        }
        return value;
    }
}
