import java.util.LinkedList;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class LeetCode0004 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // 定义2个指针，分别扫描nums1和nums2
    int nums1Index = 0, nums2Index = 0;
    // 定义合并后的升序数组
    LinkedList<Integer> sum_nums = new LinkedList<>();
    // 根据指针的位置，比较2个指针当前对应值得大小
    while (nums1Index < nums1.length || nums2Index < nums2.length) {
      // 如果2遍历完了，剩下1了，则直接叠加到结果数组后面
      if (nums1Index >= nums1.length) {
        sum_nums.add(nums2[nums2Index]);
        nums2Index++;
        continue;
      }
      // 如果1遍历完了，剩下2了，则直接叠加到结果数组后面
      if (nums2Index >= nums2.length) {
        sum_nums.add(nums1[nums1Index]);
        nums1Index++;
        continue;
      }
      // 如果两者相等，则任选其一直接叠加到结果数组后面
      if ((nums1[nums1Index] == nums2[nums2Index])) {
        sum_nums.add(nums1[nums1Index]);
        nums1Index++;
        continue;
      }
      // 如果2>1，则选1叠加到结果数组后面
      if ((nums1[nums1Index] < nums2[nums2Index])) {
        sum_nums.add(nums1[nums1Index]);
        nums1Index++;
      } else if (nums1[nums1Index] > nums2[nums2Index]) { // 如果1>2，则选2叠加到结果数组后面
        sum_nums.add(nums2[nums2Index]);
        nums2Index++;
      }
    }
    int v = sum_nums.size() / 2;
    // 有2个中位数
    if (sum_nums.size() % 2 == 0) {
      int i = sum_nums.get(v - 1) + sum_nums.get(v);
      return i / 2.00;
    }
    // 有1个中位数
    return sum_nums.get(v);
  }

  public static void main(String[] args) {
    double medianSortedArrays = new LeetCode0004().findMedianSortedArrays(
            new int[]{1, 4, 6},
            new int[]{2, 3, 5}
    );
    System.out.println(medianSortedArrays);
    System.out.println(4 / 2);
    System.out.println(5 / 2);
    System.out.println(4 % 2);
    System.out.println(5 % 2);
  }
}
