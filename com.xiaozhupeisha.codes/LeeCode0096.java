/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 */
public class LeeCode0096 {

  public int numTrees(int n) {
    int[][] memo = new int[n + 1][n + 1];
    return build(1, n, memo);
  }

  public int build(int l, int r, int[][] memo) {
    int result = 0;
    // base-case
    if (l > r) {
      result = 1;
      return result;
    }
    if (memo[l][r] != 0) {
      return memo[l][r];
    }
    for (int i = l; i <= r; i++) {
      int left = build(l, i - 1, memo);
      int right = build(i + 1, r, memo);
      result += left * right;
    }
    // 将结果存入备忘录
    memo[l][r] = result;
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new LeeCode0096().numTrees(18));
  }
}
