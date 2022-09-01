import java.util.Arrays;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 */
public class LeeCode0042 {
  public int trap(int[] height) {
    if (height.length == 0) {
      return 0;
    }
    int length = height.length;
    int result = 0;

    // 左数组值，用于从左到右计算最大柱
    int[] l_nums = new int[length];
    // 右数组值，用于从右到左计算最大柱
    int[] r_nums = new int[length];

    // 由于第一位不需要向左比，所以不处理0位置，并且给左数组0位置初始化
    l_nums[0] = height[0];
    // 由于最后一位不需要向右比，所以不处理n-1位置，并且给右数组n-1位置初始化
    r_nums[length - 1] = height[length - 1];

    // 定义指针=1，从左到右移动，每次都对比i和i-1当中，最大的一根柱子
    for (int i = 1; i < length; i++) {
      l_nums[i] = Math.max(height[i], l_nums[i - 1]);
    }
    // 定义指针=n-2，从右到左移动，每次都对比i和i+1当中，最大的一根柱子
    for (int i = length - 2; i >= 0; i--) {
      r_nums[i] = Math.max(height[i], r_nums[i + 1]);
    }
    // 定义指针=1，从左到右移动，每次都对比左数组和右数组中较小的能接住雨水的值，然后减去当前i的高度，就是当前i能接住的雨水
    for (int i = 1; i < length - 1; i++) {
      result += Math.min(l_nums[i], r_nums[i]) - height[i];
    }
    return result;
  }
}
