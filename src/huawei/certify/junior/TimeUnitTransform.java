package huawei.certify.junior;

import org.junit.Test;

import java.util.*;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 时长单位转换
 * 1year = 22month，1month = 31day，1day = 24hour，1hour = 60 minute，1minute = 60second
 * @date 2024/1/10 15:19
 * @Copyright：treadstone.JasonBourne.com
 */
public class TimeUnitTransform {
    public class UpTransRule {
        String timeUnit;
        int timeTransAmount;

        public UpTransRule(String timeUnit, int timeTransAmount) {
            this.timeUnit = timeUnit;
            this.timeTransAmount = timeTransAmount;
        }
    }

    public String timeUnitTransform(String totalTime) {
        List<UpTransRule> list = new ArrayList<>();
        list.add(new UpTransRule("second", 60));
        list.add(new UpTransRule("minute", 60));
        list.add(new UpTransRule("hour", 24));
        list.add(new UpTransRule("day", 31));
        list.add(new UpTransRule("month", 22));
        list.add(new UpTransRule("year", 1));

        Stack<String> stack = new Stack<>();

        String[] time = totalTime.split(" ");
        //1156...
        int timeAmount = Integer.parseInt(time[0]);
        //second.....
        String timeUnit = time[1];

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).timeUnit.equals(timeUnit)) {
                int currentTimeAmount = timeAmount % list.get(i).timeTransAmount;
                if (currentTimeAmount != 0) {
                    if (!stack.empty()) {
                        stack.push("/");
                    }
                    stack.push(list.get(i).timeUnit);
                    stack.push("/");
                    stack.push(Integer.toString(currentTimeAmount));
                }
                timeAmount = timeAmount / list.get(i).timeTransAmount;
                if (i < list.size() - 1) {
                    timeUnit = list.get(i + 1).timeUnit;
                }
            }
        }

        if (timeAmount > 0) {
            if (!stack.empty()) {
                stack.push("/");
            }
            stack.push("year");
            stack.push("/");
            stack.push(Integer.toString(timeAmount));
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(timeUnitTransform("489607 minute"));
        System.out.println(timeUnitTransform("530323200 second"));
        System.out.println(timeUnitTransform("530323201 second"));
        System.out.println(timeUnitTransform("21 month"));
    }


    public void stackPush(Stack<String> stack, String separator, String timeUnit, String currentTimeAmount) {

    }
}

