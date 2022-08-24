import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 */
public class LeeCode0015 {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    Set<List<Integer>> lists = numSum(nums, 3, 0, 0);
    List<List<Integer>> newLists = new ArrayList<>();
    newLists.addAll(lists);
    return newLists;
  }

  /**
   * 目标数组、N数、指针、N数之和
   *
   * @param nums
   * @param numbers
   * @param point
   * @param target
   * @return
   */
  public Set<List<Integer>> numSum(int[] nums, int numbers, int point, int target) {
    Set<List<Integer>> results = new HashSet<>();
    // 如果数组里面没有值，或者说只有1个值，那么就只能直接返回了
    // 如果说要求的数字数量的值超出了数组的界限，则直接返回，不管了
    if (nums.length < 2 || nums.length < numbers) {
      List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
      results.add(numsList);
      return results;
    }
    // 栈的最底层，就是执行到它了，它会弹出，顺带上面积压的所有都会挨个弹出
    if (numbers == 2) {
      return twosum(nums, point, target);
    }
    // 把问题简化为，5 = 1+1+1+2，通过递归
    // 数组是经过排序的，我们从左到右遍历，移动指针
    for (int i = point; i < nums.length; i++) {
      Set<List<Integer>> res = numSum(nums, numbers - 1, i + 1, target - nums[i]);
      for (List<Integer> re : res) {
        List<Integer> re1 = new ArrayList<>(re);
        re1.add(nums[i]);
        results.add(re1);
      }
      while (i < (nums.length - 1) && nums[i] == nums[i + 1]) i++;
    }
    return results;
  }

  /**
   * 两数之和问题
   *
   * @param nums
   * @param target
   * @return
   */
  private static Set<List<Integer>> twosum(int[] nums, int point, int target) {
    Set<List<Integer>> results = new HashSet<>();
    // 转化为2sum的问题，使用双指针
    int l = point, r = nums.length - 1;
    while (l < r) {
      int sum = nums[l] + nums[r];
      int left = nums[l];
      int right = nums[r];
      if (sum < target) {
        while (l < r && nums[l] == left) l++; // 应对 1，1，1，5这种情况
      } else if (sum > target) {
        while (l < r && nums[r] == right) r--;// 应对 1，5，5，5这种情况
      } else {
        List<Integer> integers = Arrays.asList(left, right);
        results.add(integers);// 2sum
        while (l < r && nums[l] == left) l++; // 应对 1，1，1，5这种情况
        while (l < r && nums[r] == right) r--;// 应对 1，5，5，5这种情况
      }
    }
    return results;
  }

  public static void main(String[] args) {
//    解答失败: 测试用例:[-1,0,1,2,-1,-4,-2,-3,3,0,4]
//    测试结果:[[0,4,-4],[1,3,-4],[-1,4,-3],[0,3,-3],[1,2,-3],         ,[0,2,-2],[-1,2,-1],[0,1,-1]]
//    期望结果:[[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
    List<List<Integer>> x = new LeeCode0015().threeSum(new int[]{
            -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4
    });
    System.out.println(x);
  }
}
