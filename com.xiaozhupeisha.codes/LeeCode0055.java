import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
public class LeeCode0055 {
  public boolean canJump(int[] nums) {
    int length = nums.length;
    int fastest = 0;

    for (int i = 0; i < length - 1; i++) {
      fastest = Math.max(fastest, nums[i] + i);
      if (fastest <= i) {
        return false;
      }
    }
    return fastest >= length - 1;
  }

  public static void main(String[] args) {
    boolean b = new LeeCode0055().canJump(new int[]{2, 3, 1, 1, 4});
    System.out.println(b);
  }
}
