package LeetCode.string;

/**
 * @Author zkx
 * @ClassName LongestCommonSubsequence
 * @Description TODO 1143. 最长公共子序列 medium
 * 最长公共子序列问题是典型的二维动态规划问题。
 * https://www.bilibili.com/video/BV1ey4y1d7oD/?spm_id_from=333.337.search-card.all.click&vd_source=72037f2042f3e8fc6f656fe5933cc2ac
 * @Date 2023/2/7 14:10
 * Version 1.0
 **/
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] arr = new int[length1 + 1][length2 + 1];
        //第一行第一列默认是0
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }
        return arr[length1][length2];
    }
}
