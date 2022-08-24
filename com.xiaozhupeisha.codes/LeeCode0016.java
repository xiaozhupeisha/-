import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 */
public class LeetCode0016 {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    return numSum(nums, 0, target);
  }

  public int numSum(int[] nums, int point, int target) {
    // 如果数组里面没有值，或者说只有3个值，那么就只能直接返回了
    if (nums.length < 3) {
      return 0;
    }
    int delta = Integer.MAX_VALUE;

    // 最后2个数字不要了，因为他们太大了，而且最后一次也会覆盖倒数123个数字的
    for (int i = point; i < nums.length - 2; i++) {
      // 转化为找出i+1开始的2个数的值，这2个数需要距离target-当前i的值最近
      int sum = nums[i] + twosumClosest(nums, i + 1, target - nums[i]);
      int i1 = target - sum;// 剩余当前数字需要和它比对，并且要比他小的优先，相当于3数之和最近的
      // 这里有一个2次比对，比对这次三数之和最小的和上一次迭代最小的，取更小的
      if (Math.abs(i1) < Math.abs(delta)) {
        delta = i1;
      }
    }
    return target - delta;
  }

  private static int twosumClosest(int[] nums, int point, int target) {
    int l = point, r = nums.length - 1;
    int delta = Integer.MAX_VALUE;
    while (l < r) {
      int sum = nums[l] + nums[r];
      // 取2数字之和距离目标值的最小的一次结果
      if (Math.abs(target - sum) < Math.abs(delta)) {
        delta = target - sum;
      }
      if (sum < target) {
        l++;
      } else {
        r--;
      }
    }
    return target - delta;
  }

  public static void main(String[] args) {
    int i = new LeetCode0016().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
    System.out.println(i);
  }
}
