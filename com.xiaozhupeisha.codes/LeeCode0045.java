/**
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是
 * 2
 */
public class LeeCode0045 {
  public int jump(int[] nums) {
    int length = nums.length;
    int jump = 0;
    int fathest = 0;
    int end = 0;

    for (int i = 0; i < length - 1; i++) {
      // 可以跳跃的步数
      int j = nums[i];
      // 当前节点能跳出去最远的距离
      fathest = Math.max(fathest, nums[i] + i);
      if(end == i){
        end = fathest;
        jump++;
      }
    }

    return jump;
  }

  public static void main(String[] args) {
    int jump = new LeeCode0045().jump(new int[]{});
    System.out.println(jump);
  }
}
