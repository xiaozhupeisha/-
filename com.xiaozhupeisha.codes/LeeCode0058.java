import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 */
public class LeeCode0058 {
  public int lengthOfLastWord(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int word = 0;
    int j = s.length() - 1;
    while (j < s.length()) {
      if (!String.valueOf(s.charAt(j)).equals(" ")) {
        break;
      }
      j--;
    }
    while (j < s.length() && j >= 0) {
      if (String.valueOf(s.charAt(j)).equals(" ")) {
        break;
      }
      word++;
      j--;
    }
    return word;
  }

  public static void main(String[] args) {
    int hello_world = new LeeCode0058().lengthOfLastWord("a");
    System.out.println(hello_world);
  }
}
