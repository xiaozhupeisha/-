/**
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * 你必须尽可能减少整个操作步骤。
 */
public class LeeCode0081 {

  public boolean search(int[] nums, int target) {
    // 二分搜索
    int length = nums.length;
    int l = 0, r = length - 1;

    while (l <= r) {
      // 每次都获取到中位数
      int mid = (l + r) / 2;
      // 如果中位数等于目标值则返回
      if (nums[mid] == target) {
        return true;
      }
      // 如果中位数等于左边界且中位数等于有边界，则扩散指针
      if (nums[mid] == nums[l] && nums[mid] == nums[r]) {
        l++;
        r--;
        continue;
      }
      // 如果左边界小于中位数
      if (nums[l] <= nums[mid]) {
        // 如果左边界小于目标值并且目标值小于中位数，则收缩右边界，否则收缩左边界
        if (nums[l] <= target && target < nums[mid]) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
        continue;
      }
      // 如果左边界大于中位数
      if (nums[l] > nums[mid]) {
        // 如果目标值小于数组最后一位且大于中位数，则收缩左边界，否则收缩右边界
        if (nums[length - 1] >= target && target > nums[mid]) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    boolean search = new LeeCode0081().search(new int[]{2
            , 5, 6, 0, 0, 1, 2}, 0);
    System.out.println(search);
  }
}
