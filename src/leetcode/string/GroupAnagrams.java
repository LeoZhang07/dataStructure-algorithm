package leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zkx
 * @ClassName GroupAnagrams
 * @Description TODO 49. 字母异位词分组
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * 输入：strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * @Date 2023/2/2 10:58
 * Version 1.0
 **/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] charCount = new int[26];
            //统计str中每个字符出现的频率
            for (int i = 0; i < str.length(); i++) {
                charCount[str.charAt(i) - 'a']++;
            }
            //构建类似于a3c1e这种[字符+频次]的key
            for (int i = 0; i < 26; i++) {
                if (charCount[i] > 0) {
                    sb.append(i + 'a');
                    sb.append(charCount[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
            sb.setLength(0);
        }
        List<List<String>> list = new ArrayList<>();
        map.forEach((key, value) -> {
            list.add(value);
        });
        return list;
    }
}
