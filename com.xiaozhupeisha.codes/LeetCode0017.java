import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 */
public class LeetCode0017 {

  public List<String> letterCombinations(String digits) {

    return new ArrayList<>();
  }

  public static void main(String[] args) {
    List<String> strings = new LeetCode0017().letterCombinations("23");
    System.out.println(strings);
  }
}
