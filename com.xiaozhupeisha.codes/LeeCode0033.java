/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class LeeCode0033 {
  public int search(int[] nums, int target) {
    return search(nums, nums.length, target);
  }

  static int search(int[] nums, int numsSize, int target) {
    int i;
    if (numsSize == 0) {
      return -1;
    }
    for (i = 0; i < numsSize / 2 + 1; i++) {
      if (nums[i] == target) {
        return i;
      } else if (nums[numsSize - i - 1] == target) {
        return numsSize - i - 1;
      } else {
        continue;
      }
    }

    return -1;
  }
}
