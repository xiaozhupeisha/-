/**
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 */
public class LeeCode0036 {
  public boolean isValidSudoku(char[][] board) {
    // 定义行二维数组，来维护这个值在一整行/列中出现的次数
    int[][] rows = new int[9][9];
    // 定义列二维数组，来维护这个值在一整行/列中出现的次数
    int[][] cols = new int[9][9];
    // 定义列三维数组，针对于9宫格中某个数字出现的次数
    int[][][] jiugongge = new int[3][3][9];

    // 定义i和9，双重for循环，得到99 81个坐标的值
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        // 获取i，j坐标下的值
        int index = board[i][j] - '0' - 1;
        if (board[i][j] == '.') {
          continue;
        }
        // 比方如果数字5在第一行出现了1次则，i[1][5-1]=1
        // 比方如果数字5在第一行出现了2次则，i[1][5-1]=2
        rows[i][index]++;
        cols[j][index]++;

        // 维护(i,j)值在i-j所对应的的9宫格内的出现次数
        jiugongge[i / 3][j / 3][index]++;

        if (rows[i][index] > 1 || cols[j][index] > 1 || jiugongge[i / 3][j / 3][index] > 1) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[][] rows = new int[9][9];
    System.out.println(rows);
  }
}
