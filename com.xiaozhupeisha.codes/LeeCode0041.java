import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 */
public class LeeCode0041 {
  public int firstMissingPositive(int[] nums) {
    int min = 1;
    if (nums == null || nums.length == 0) {
      return min;
    }
    //先排序
    Arrays.sort(nums);
    for (int num : nums) {
      if (num == min) {
        min++;
      }
    }
    return min;
  }

  public static void main(String[] args) {
    LeeCode0041 solution = new LeeCode0041();
    int i = solution.firstMissingPositive(new int[]{1, 3, 4, 6});
    System.out.println(i);
  }
}
