import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class LeeCode0073 {
  public void setZeroes(int[][] matrix) {
    Set<Integer> rowSet = new HashSet<>();
    Set<Integer> colSet = new HashSet<>();

    // 标记哪些行或者列需要设置0
    int row = matrix.length;
    int col = matrix[0].length;
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if(matrix[r][c] == 0){
          rowSet.add(r);
          colSet.add(c);
        }
      }
    }

    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if(rowSet.contains(r) || colSet.contains(c)){
          matrix[r][c] = 0;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[][] ints = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    new LeeCode0073().setZeroes(ints);
    System.out.println(true);
  }
}
