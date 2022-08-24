/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 */
public class LeeCode0011 {

  /**
   * s 和 p 相互匹配的过程大致是，两个指针 i, j 分别在 s 和 p 上移动，如果最后两个指针都能移动到字符串的末尾，那么就匹配成功，反之则匹配失败。
   * 正则表达算法问题只需要把住一个基本点：看 s[i] 和 p[j] 两个字符是否匹配，一切逻辑围绕匹配/不匹配两种情况展开即可。
   * 动态规划算法的核心就是「状态」和「选择」，「状态」无非就是 i 和 j 两个指针的位置，「选择」就是模式串的 p[j] 选择匹配几个字符。
   */
  public int maxArea(int[] height) {
    int leftPoint = 0, rightPoint = height.length - 1;

    int maxVal = 0;
    while (leftPoint <= rightPoint) {
      int leftVal = height[leftPoint];
      int rightVal = height[rightPoint];

      // 计算出最大容积
      int max = (rightPoint - leftPoint) * Math.min(leftVal, rightVal);
      if (leftVal <= rightVal) {
        leftPoint++;
      }
      if (leftVal > rightVal) {
        rightPoint--;
      }
      maxVal = Math.max(maxVal, max);
    }

    return maxVal;
  }

  public static void main(String[] args) {
    System.out.println(new LeeCode0011().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }
}
