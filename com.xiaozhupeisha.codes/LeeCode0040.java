import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5] , target = 8
 * 输出: [ [1,1,6], [1,2,5], [1,7], [2,6] ]
 */
public class LeeCode0040 {
  LinkedList<List<Integer>> result = new LinkedList<>();
  LinkedList<Integer> track = new LinkedList<>();
  int trackSum = 0;

  public void backtrack(int[] nums, int start, int target) {
    if (trackSum == target) {
      result.add(new LinkedList<>(track));
      return;
    }
    if (trackSum > target) {
      return;
    }
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) {
        continue;
      }
      trackSum += nums[i];
      track.add(nums[i]);

      backtrack(nums, i + 1, target);

      trackSum -= nums[i];
      track.removeLast();
    }
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if (candidates.length == 0) {
      return result;
    }
    Arrays.sort(candidates);
    backtrack(candidates, 0, target);
    return result;
  }

  public static void main(String[] args) {
    LeeCode0040 solution = new LeeCode0040();
    List<List<Integer>> lists = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    for (List<Integer> list : lists) {
      System.out.println("结果start");
      for (Integer integer : list) {
        System.out.println(integer);
      }
    }
  }
}
