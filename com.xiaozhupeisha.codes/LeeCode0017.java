import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 */
public class LeeCode0017 {

  private String letterMap[] = {
          " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"  //9
  };

  private ArrayList<String> res;

  /**
   * 解决一个回溯问题，实际上就是一个决策树的遍历过程，站在回溯树的一个节点上，你只需要思考 3 个问题：
   * 1、路径：也就是已经做出的选择。
   * 2、选择列表：也就是你当前可以做的选择。
   * 3、结束条件：也就是到达决策树底层，无法再做选择的条件。
   */
  public List<String> letterCombinations(String digits) {

    res = new ArrayList<>();
    if (digits.equals("")) return res;

    // 通过递归，实现回溯算法
    findCombination(digits, 0, "");
    return res;
  }

  /**
   * @param digits:   23,34,2~9 两两组合的
   * @param index:    路径的长度，在这里就1或者2
   * @param indexStr: 路径的值，比如"a"，"ad"
   */
  private void findCombination(String digits, int index, String indexStr) {
    // 如果路径长度到达了目标的值，比如说在这里就是2。则加入当前路径生成的值
    if (index == digits.length()) {
      System.out.println("达到目标值,digits=" + digits + ",index=" + index + ",indexStr=" + indexStr);
      res.add(indexStr);
      return;
    }
    // 如果路径没走到底，则根据树的根节点，进行递归
    char c = digits.charAt(index);
    System.out.println("当前节点digits" + c);
    String letter = letterMap[c - '0'];
    System.out.println("当前节点所有值" + letter);
    for (int i = 0; i < letter.length(); i++) {
      System.out.println("开始回溯,digits=" + digits + ",index=" + (index + 1) + ",indexStr=" + indexStr + letter.charAt(i));
      findCombination(digits, index + 1, indexStr + letter.charAt(i));
    }

  }

  public static void main(String[] args) {
    List<String> strings = new LeeCode0017().letterCombinations("23");
    System.out.println(strings);
  }
}
