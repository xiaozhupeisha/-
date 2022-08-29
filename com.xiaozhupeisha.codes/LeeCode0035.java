/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class LeeCode0035 {
  public int searchInsert(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    }
    int l = 0;
    int r = nums.length;
    while (l < r) {
      System.out.println("=====================");
      System.out.println("l=" + l + ",r=" + r);
      int mid = l + (r - l) / 2;
      System.out.println("mid=" + mid);
      System.out.println("nums[mid]=" + nums[mid]);
      System.out.println("target=" + target);
      if (nums[mid] == target) {
        r = mid;
      } else if (nums[mid] < target) {
        l = mid + 1;
      } else if (nums[mid] > target) {
        r = mid;
      }
      System.out.println("l=" + l + ",r=" + r);
      System.out.println("=====================");
    }
    return l;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1,2,3,4,5,6,7};
    new LeeCode0035().searchInsert(nums, 4);
  }

}
