import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class LeeCode0054 {
  List<Integer> res = new LinkedList<>();

  public List<Integer> spiralOrder(int[][] matrix) {
    // m=高，n=宽
    int m = matrix.length, n = matrix[0].length;
    int upper_bound = 0, lower_bound = m - 1;
    int left_bound = 0, right_bound = n - 1;

    // 按照右、下、左、上的顺序遍历数组，并使用四个变量圈定未遍历元素的边界
    while (res.size() < m * n) {
      if (upper_bound <= lower_bound) {
        // 在顶部从左向右遍历
        for (int j = left_bound; j <= right_bound; j++) {
          res.add(matrix[upper_bound][j]);
        }
        // 上边界下移
        upper_bound++;
      }

      if (left_bound <= right_bound) {
        // 在右侧从上向下遍历
        for (int i = upper_bound; i <= lower_bound; i++) {
          res.add(matrix[i][right_bound]);
        }
        // 右边界左移
        right_bound--;
      }

      if (upper_bound <= lower_bound) {
        // 在底部从右向左遍历
        for (int j = right_bound; j >= left_bound; j--) {
          res.add(matrix[lower_bound][j]);
        }
        // 下边界上移
        lower_bound--;
      }

      if (left_bound <= right_bound) {
        // 在左侧从下向上遍历
        for (int i = lower_bound; i >= upper_bound; i--) {
          res.add(matrix[i][left_bound]);
        }
        // 左边界右移
        left_bound++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    List<Integer> integers = new LeeCode0054().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    for (Integer i : integers) {
      System.out.println(i);
    }
  }
}
