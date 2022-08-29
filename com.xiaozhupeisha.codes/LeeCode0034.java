/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 */
public class LeeCode0034 {
  public int[] searchRange(int[] nums, int target) {
    return new int[]{left_bound(nums, target), right_bound(nums, target)};
  }

  int left_bound(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    // 搜索区间为 [left, right]
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        // 搜索区间变为 [mid+1, right]
        left = mid + 1;
      } else if (nums[mid] > target) {
        // 搜索区间变为 [left, mid-1]
        right = mid - 1;
      } else if (nums[mid] == target) {
        // 收缩右侧边界
        right = mid - 1;
      }
    }
    // 检查出界情况
    if (left >= nums.length || nums[left] != target) {
      return -1;
    }
    return left;
  }

  int right_bound(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] == target) {
        // 这里改成收缩左侧边界即可
        left = mid + 1;
      }
    }
    // 这里改为检查 right 越界的情况，见下图
    if (right < 0 || nums[right] != target) {
      return -1;
    }
    return right;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 4, 4, 4, 5};
    int[] ints = new LeeCode0034().searchRange(nums, 4);
  }

}
