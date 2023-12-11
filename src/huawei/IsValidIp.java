package huawei;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 一面，判断是否有效的ip，前后可以为空字符，中间不能为空字符，可以是0.0.0.0,不能是01.02.03.04
 * @date 2023/10/24 20:33
 * @Copyright：treadstone.JasonBourne.com
 */
public class IsValidIp {
    public boolean isValidIp(String ip) {
        //Java中的String类提供了一个trim()方法，可以去除字符串开头和结尾的空格。该方法会返回一个新的字符串，其中不包含开头和结尾的空格。
        String trimmedIp = ip.trim();
        //split
        String[] splitIp = trimmedIp.split(".");
        //int curSection = 0;

        for (String part : splitIp) {
            for (int i = 0; i < part.length(); i++) {
                if (part.charAt(i) == '0' && i != part.length() - 1) {
                    return false;
                }

                //
                if (part.charAt(i) == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
