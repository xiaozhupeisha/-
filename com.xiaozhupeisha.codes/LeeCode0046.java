import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class LeeCode0046 {
  // 存放结果数组
  public List<List<Integer>> result = new LinkedList();
  // 存放结果数组
  LinkedList<Integer> track = new LinkedList<>();
  // 定义回溯树中，每个元素的使用情况，因为不能重复使用
  boolean[] hasUsed;

  public List<List<Integer>> permute(int[] nums) {
    // 初始化数组长度，123的话就是3
    hasUsed = new boolean[nums.length];
    backtrack(nums);
    return result;
  }

  public void backtrack(int[] nums) {
    // base-case
    if (track.size() == nums.length) {
      result.add(new LinkedList<>(track));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      // 剪枝
      if (hasUsed[i]) continue;

      //选择
      track.add(nums[i]);
      hasUsed[i] = true;

      // 进入下一层决策树
      backtrack(nums);

      // 取消选择
      track.removeLast();
      hasUsed[i] = false;
    }
  }

  public static void main(String[] args) {
  }
}
