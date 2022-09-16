import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 */
public class LeeCode0077 {
  LinkedList<List<Integer>> result = new LinkedList<>();
  LinkedList<Integer> track = new LinkedList<>();

  public List<List<Integer>> combine(int n, int k) {
    if (k <= 0 || n <= 0) return result;
    // 回溯算法
    backtrack(n, k, 1);
    return result;
  }

  private void backtrack(int n, int k, int index) {
    // base-case
    if (track.size() == k) {
      result.add(new LinkedList<>(track));
      return;
    }
    // 遍历
    for (int i = index; i <= n; i++) {
      // 做选择
      track.addLast(i);
      // 下一层回溯树
      // 通过 start 参数控制树枝的遍历，避免产生重复的子集
      backtrack(n, k, i + 1);
      // 撤销选择
      track.removeLast();
    }
  }

  public static void main(String[] args) {
    List<List<Integer>> combine = new LeeCode0077().combine(4, 2);
    for (List<Integer> integers : combine) {
      System.out.println("===");
      for (Integer integer : integers) {
        System.out.println(integer);
      }
      System.out.println("===");
    }
  }
}
