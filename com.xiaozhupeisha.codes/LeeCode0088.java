/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class LeeCode0088 {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int index = nums1.length - 1;
    int mm = m - 1;
    int nn = n - 1;

    while (mm >= 0 && nn >= 0){
      if(nums1[mm] > nums2[nn]){
        nums1[index] = nums1[mm];
        mm --;
        index --;
      }else {
        nums1[index] = nums2[nn];
        nn --;
        index --;
      }
    }

    while (nn >= 0){
      nums1[index] =nums2[nn];
      index--;
      nn--;
    }
  }

  public static void main(String[] args) {
    LeeCode0088 leeCode0086 = new LeeCode0088();
    int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
    int[] nums2 = new int[]{2, 5, 6};
    leeCode0086.merge(nums1, 3, nums2, 3);
    System.out.println(1);
  }

}
