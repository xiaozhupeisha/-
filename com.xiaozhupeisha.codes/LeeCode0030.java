import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 * 示例 1：
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：
 * [0,9]
 */
public class LeeCode0030 {
  public List<Integer> findSubstring(String s, String[] words) {
    //单词个数
    int n = words.length; //单词长度
    int wordLength = words[0].length();
    List<Integer> ans = new ArrayList<>();
    //存放所有单词
    Map<String, Integer> wordsMap = new HashMap<>();
    for (String word : words) {
      wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
    }
    //移动i
    for (int i = 0; i < s.length() - wordLength * n + 1; i++) {
      HashMap<String, Integer> curMap = new HashMap<>();
      //是否存在异常情况
      boolean errorFlag = false;
      for (int j = 0; j < n; j++) {
        //第j个单词
        String curWord = s.substring(i + j * wordLength, i + (j + 1) * wordLength); //出现不存在单词
        if (!wordsMap.containsKey(curWord)) {
          errorFlag = true;
          break;
        }
        curMap.put(curWord, curMap.getOrDefault(curWord, 0) + 1);
        //出现超数量单词
        if (curMap.get(curWord) > wordsMap.get(curWord)) {
          errorFlag = true;
          break;
        }
      }
      // 没有异常情况
      //记录答案
      if (!errorFlag) {
        ans.add(i);
      }
    }
    return ans;
  }
}