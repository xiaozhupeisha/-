import java.util.Stack;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 */
public class LeeCode0032 {
  public int longestValidParentheses(String s) {
    Stack<Integer> stk = new Stack<>();
    // dp[i] 的定义：记录以 s[i-1] 结尾的最长合法括号子串长度
    int[] dp = new int[s.length() + 1];
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        // 遇到左括号，记录索引
        stk.push(i); // 左括号不可能是合法括号子串的结尾
        dp[i + 1] = 0;
      } else { // 遇到右括号
        if (!stk.isEmpty()) { // 配对的左括号对应索引
          int leftIndex = stk.pop(); // 以这个右括号结尾的最长子串长度
          int len = 1 + i - leftIndex + dp[leftIndex];
          dp[i + 1] = len;
        } else {
          // 没有配对的左括号
          dp[i + 1] = 0;
        }
      }
    }
    // 计算最长子串的长度
    int res = 0;
    for (int j : dp) {
      res = Math.max(res, j);
    }
    return res;
  }

  public static void main(String[] args) {
    int i = new LeeCode0032().longestValidParentheses("()()");
    System.out.println(i);
  }
}
