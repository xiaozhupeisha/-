import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：[[1,1,2],[1,2,1],[2,1,1]]
 */
public class LeeCode0047 {
  // 存放结果数组
  public List<List<Integer>> result = new LinkedList();
  // 存放结果数组
  LinkedList<Integer> track = new LinkedList<>();
  // 定义回溯树中，每个元素的使用情况，因为不能重复使用
  boolean[] hasUsed;

  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
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

      // 防重复剪枝
      if (i > 0 && (nums[i] == nums[i - 1]) && hasUsed[i - 1]) {
        continue;
      }

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
