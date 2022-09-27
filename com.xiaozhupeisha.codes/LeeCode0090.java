import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class LeeCode0090 {
  private List<List<Integer>> result = new LinkedList<>();
  LinkedList<Integer> track = new LinkedList<>();

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    backtrack(nums, 0);
    return result;
  }

  public void backtrack(int[] nums, int start) {
    // 子集问题无base-case
    result.add(new LinkedList<>(track));

    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) {
        continue;
      }
      // 做选择
      track.addLast(nums[i]);
      // 下一层回溯树
      backtrack(nums, i + 1);
      // 取消选择
      track.removeLast();
    }
  }

  public static void main(String[] args) {
    LeeCode0090 leeCode0086 = new LeeCode0090();
    int[] nums = new int[]{1, 2, 2};
    List<List<Integer>> lists = leeCode0086.subsetsWithDup(nums);
    System.out.println(lists);
  }

}
