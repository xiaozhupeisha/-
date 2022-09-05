import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 */
public class LeeCode0049 {

  public List<List<String>> groupAnagrams(String[] strs) {
    // 编码到分组的映射
    HashMap<String, List<String>> codeToGroup = new HashMap<>();
    for (String s : strs) {
      // 对字符串进行编码
      String code = encode(s);
      // 把编码相同的字符串放在一起
      codeToGroup.putIfAbsent(code, new LinkedList<>());
      codeToGroup.get(code).add(s);
    } // 获取结果
    return new LinkedList<>(codeToGroup.values());
  }

  // 利用每个字符的出现次数进行编码
  String encode(String s) {
    char[] count = new char[26];
    for (char c : s.toCharArray()) {
      int delta = c - 'a';
      count[delta]++;
    }
    return new String(count);
  }
}
