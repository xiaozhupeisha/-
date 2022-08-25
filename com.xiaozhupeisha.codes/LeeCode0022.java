import java.util.LinkedList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class LeeCode0022 {

  List<String> result = new LinkedList<>();

  /**
   * n代表有几对括号，n=2，则()()两对
   */
  public List<String> generateParenthesis(int n) {
    backtrack(n, n, new StringBuilder());
    return result;
  }

  /**
   * 回溯算法的经典模板
   */
  public void backtrack(int l, int r, StringBuilder s) {
    // 如果左右括号的数量用尽还少了，则不执行
    if (l < 0 || r < 0) return;
    // 如果用掉得到右括号比左括号多了，则不符合
    if (l > r) return;
    // 如果到达了树的底部,则返回值
    if (l == 0 && r == 0) {
      result.add(s.toString());
      return;
    }

    // 压入一个左括号，如果情况不对内部会自动把这次压入的栈弹出
    s.append("(");
    backtrack(l - 1, r, s);
    s.deleteCharAt(s.length() - 1);

    // 压入一个右括号，如果情况不对内部会自动把这次压入的栈弹出
    s.append(")");
    backtrack(l, r - 1, s);
    s.deleteCharAt(s.length() - 1);
  }

}
