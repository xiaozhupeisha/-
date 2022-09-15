
/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class LeeCode0074 {
  public boolean searchMatrix(int[][] matrix, int target) {
    int row = matrix.length;
    int col = matrix[0].length;

    boolean has = false;
    for (int r = 0; r < row; r++) {
      if (r < row - 1 && matrix[r + 1][0] < target) {
        continue;
      }
      for (int c = 0; c < col; c++) {
        if (matrix[r][c] == target) {
          has = true;
          break;
        }
      }
      if (r < row - 1 && matrix[r + 1][0] > target) {
        break;
      }
    }
    return has;
  }

  public static void main(String[] args) {
    int[][] ints = {{1, 2, 3}, {4, 4, 6}, {7, 8, 9}};
    boolean b = new LeeCode0074().searchMatrix(ints, 5);
    System.out.println(b);
  }
}
