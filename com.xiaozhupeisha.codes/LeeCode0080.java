import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class LeeCode0080 {

  public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    }
    int s = 0, f = 0, count = 0;
    while (f < nums.length) {
      // 如果快指针当前的值不等于慢指针的值，则慢指针当前值更新为快指针的值，并且移动慢指针
      if (nums[s] != nums[f]) {
        s++;
        nums[s] = nums[f];
      } else if (count < 2 && s < f) {
        // 如果快指针当前的值等于慢指针的值，并且备忘录<2，则慢指针当前值更新为快指针的值，并且移动慢指针
        s++;
        nums[s] = nums[f];
      }
      // 快指针移动，备忘录++
      f++;
      count++;
      // 如果快指针当前的值和前一位的值不等，则初始化备忘录
      if (f < nums.length && nums[f] != nums[f - 1]) {
        count = 0;
      }
    }
    return s + 1;
  }

  public static void main(String[] args) {
    int i = new LeeCode0080().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
    System.out.println(i);
  }
}
