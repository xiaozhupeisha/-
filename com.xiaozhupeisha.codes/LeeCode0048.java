/**
 * 给定一个 nxn 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class LeeCode0048 {

  public void rotate(int[][] matrix) {
    int length = matrix.length;
    // 对折
    for (int i = 0; i < length; i++) {
      for (int j = i; j < length; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }
    // 反转
    for (int[] row : matrix) {
      int j = row.length - 1;
      int i = 0;
      while (i < j) {
        int tmp = row[i];
        row[i] = row[j];
        row[j] = tmp;
        j--;
        i++;
      }
    }
  }

  public static void main(String[] args) {
  }
}
