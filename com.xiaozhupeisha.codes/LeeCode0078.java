import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class LeeCode0078 {
  LinkedList<List<Integer>> result = new LinkedList<>();
  LinkedList<Integer> track = new LinkedList<>();

  public List<List<Integer>> subsets(int[] nums) {
    if (nums.length == 0) return result;
    // 回溯算法
    backtrack(nums, 0);
    return result;
  }

  private void backtrack(int[] nums, int index) {
    // base-case
    result.add(new LinkedList<>(track));

    // 遍历
    for (int i = index; i < nums.length; i++) {
      // 做选择
      track.addLast(nums[i]);
      // 下一层回溯树
      // 通过 start 参数控制树枝的遍历，避免产生重复的子集
      backtrack(nums, i + 1);
      // 撤销选择
      track.removeLast();
    }
  }

  public static void main(String[] args) {
    List<List<Integer>> combine = new LeeCode0078().subsets(new int[]{1, 2, 3});
    for (List<Integer> integers : combine) {
      System.out.println("===");
      for (Integer integer : integers) {
        System.out.println(integer);
      }
      System.out.println("===");
    }
  }
}
