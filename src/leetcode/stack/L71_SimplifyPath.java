package leetcode.stack;

import org.junit.Test;

import java.util.*;

/**
 * @author leo
 * @version 1.0
 * @description: TODO
 * @date 2024/7/21 14:51
 * @Copyright：treadstone.JasonBourne.com
 */
public class L71_SimplifyPath {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Set<String> set = new HashSet<>();
        set.add("");
        set.add(".");
        set.add("..");
        Deque<String> dq = new LinkedList<>();
        for (String s : split) {
            if ("..".equals(s) && !dq.isEmpty()) {
                dq.removeLast();
                continue;
            }
            if (!set.contains(s)) {
                dq.offer(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (dq.size() == 0) {
            return "/";
        }
        for (String s : dq) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String path = "/../";
        simplifyPath(path);
    }
}
