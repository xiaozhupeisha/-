import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 */
public class LeeCode0018 {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    if(nums.length < 4){
      return new ArrayList<>();
    }
    Arrays.sort(nums);
    Set<List<Integer>> lists = numSum(nums, 4, 0, target);
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
  public Set<List<Integer>> numSum(int[] nums, int numbers, int point, long target) {
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
  private static Set<List<Integer>> twosum(int[] nums, int point, long target) {
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
    List<List<Integer>> x = new LeeCode0018().fourSum(new int[]{
            1000000000,1000000000,1000000000,1000000000
    }, -294967296);
    System.out.println(x);
  }
}
