import java.util.Arrays;

/**
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * 示例 1：
 * 输入：n = 3, k = 3
 * 输出："213"
 */
public class LeeCode0060 {
  /**
   * 记录数字是否使用过
   */
  private boolean[] used;

  /**
   * 阶乘数组
   */
  private int[] factorial;

  private int n;
  private int k;

  public String getPermutation(int n, int k) {
    this.n = n;
    this.k = k;
    calculateFactorial(n);

    // 查找全排列需要的布尔数组
    used = new boolean[n + 1];
    Arrays.fill(used, false);

    StringBuilder path = new StringBuilder();
    backtrack(0, path);
    return path.toString();
  }

  /**
   * @param index 在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置
   * @param path
   */
  private void backtrack(int index, StringBuilder path) {
    //  base-case，搜索到叶子节点
    if (index == n) {
      return;
    }

    // 计算当前树枝还未确定的数字的全排列的个数，
    // 第 1 次进入的时候是 n - 1。4-1-0=0，代表选择了1、2、3、4，下一个就剩下3个没确定的的数字了
    int cnt = factorial[n - 1 - index];
    for (int i = 1; i <= n; i++) {
      // 1234，1243。用来做全排列的暴力搜索
      if (used[i]) {
        continue;
      }
      // 如果当前枝干下面没遍历完的阶乘，如果小于结果k，则跳过
      if (cnt < k) {
        k = k - cnt;
        continue;
      }
      // 做选择
      path.append(i);
      // 做选择
      used[i] = true;
      // 进入下一层回溯树
      backtrack(index + 1, path);
      // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
      // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
      // 撤销选择
      return;
    }
  }

  /**
   * 计算阶乘数组
   *
   * @param n
   */
  private void calculateFactorial(int n) {
    factorial = new int[n + 1];
    factorial[0] = 1;
    for (int i = 1; i <= n; i++) {
      factorial[i] = factorial[i - 1] * i;
    }
  }

  public static void main(String[] args) {
    LeeCode0060 leeCode0060 = new LeeCode0060();
    leeCode0060.calculateFactorial(5);
    System.out.println(leeCode0060.factorial);
  }
}
