import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class LeeCode0056 {
  public int[][] merge(int[][] intervals) {
    LinkedList<int[]> res = new LinkedList<>();
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    res.add(intervals[0]);// [1,3]
    for (int[] curr : intervals) {
      int[] last = res.getLast();
      if (curr[0] <= last[1]) {// [2,6]的2和[1,3]的3比 2<3
        last[1] = Math.max(last[1], curr[1]);//扩充边界
      } else {
        // 处理下一个待合并区间
        res.add(curr);// [8,10] [2,6] 8 > 6
      }
    }
    return res.toArray(new int[0][0]);
  }

  public static void main(String[] args) {
  }
}
