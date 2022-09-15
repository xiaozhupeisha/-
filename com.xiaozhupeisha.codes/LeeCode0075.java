
/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库的sort函数的情况下解决这个问题。
 */
public class LeeCode0075 {
  public void sortColors(int[] nums) {
    int p0 = 0, p1 = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (num == 1) {
        swap(nums, i, p1);
        p1++;
        continue;
      }
      if (num == 0) {
        swap(nums, i, p0);
        if(p0 < p1){
          swap(nums, i, p1);
        }
        p0++;
        p1++;
      }
    }
  }

  private void swap(int[] nums, int i, int p1) {
    int tmp = nums[i];
    nums[i] = nums[p1];
    nums[p1] = tmp;
  }

  public static void main(String[] args) {
    int[] ints = {2, 0, 2, 1, 1, 0};
    new LeeCode0075().sortColors(ints);
    System.out.println(true);
  }
}
