import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 */
public class LeeCode0001 {

  /**
   * 我们可以先对 nums 排序，然后利用的左右双指针技巧，从两端相向而行就行了：
   *
   * @param nums
   * @param target
   * @return
   */
  public int[] twoSum(int[] nums, int target) {
    // 边界值
    if (nums.length == 2) {
      return new int[]{0, 1};
    }

    // 用来排序的数组
    int[] numsBrother = Arrays.copyOf(nums, nums.length);

    // 数组排序
    Arrays.sort(numsBrother);

    // 定义左右指针下坐标
    int leftIndex = 0, rightIndex = numsBrother.length - 1;

    // 开始穷举
    while (leftIndex < rightIndex) {
      int addResult = numsBrother[leftIndex] + numsBrother[rightIndex];
      if (addResult < target) {
        leftIndex++;
      }
      if (addResult > target) {
        rightIndex--;
      }
      if (addResult == target) {
        break;
      }
    }

    // 定义正确的左右指针下坐标
    int leftRealIndex = -1, rightRealIndex = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == numsBrother[leftIndex] && leftRealIndex == -1) {
        leftRealIndex = i;
        continue;
      }
      if (nums[i] == numsBrother[rightIndex] && rightRealIndex == -1) {
        rightRealIndex = i;
      }
    }

    return new int[]{leftRealIndex, rightRealIndex};
  }

  public static void main(String[] args) {
    int[] nums = new int[]{3, 2, 3};
    int target = 6;

    int[] ints = new LeeCode0001().twoSum(nums, target);
    for (int anInt : ints) {
      System.out.println(anInt);
    }
  }
}
