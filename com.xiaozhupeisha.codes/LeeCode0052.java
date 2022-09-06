import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class LeeCode0052 {

  // 存放结果
  public List<List<String>> result = new LinkedList<>();

  public int totalNQueens(int n) {
    char[][] board = new char[n][n];
    for (char[] chars : board) {
      Arrays.fill(chars, '.');
    }
    backtrack(board, 0);
    return result.size();
  }

  /**
   * 回溯函数
   *
   * @param board 存放决策树节点的结果值列表
   * @param row   回溯的行数，第几行
   */
  public void backtrack(char[][] board, int row) {
    // base-case，放完了最后一行的皇后，决策树结果的长度等于行数、相当于遍历到底了。
    if (row == board.length) {
      List<String> list = new ArrayList<>();
      for (char[] c : board) {
        list.add(String.copyValueOf(c));
      }
      result.add(list);
      return;
    }

    // 用for循环模拟整个决策树，这里是row的长度，nxn
    int length = board[row].length;
    // 用col代表本行的列，将皇后挨个放到该行的每个列里面，做决策
    for (int col = 0; col < length; col++) {
      // 做剪枝，排除可以相互攻击的格子
      if (!valid(board, row, col)) {
        continue;
      }

      // 做选择
      board[row][col] = 'Q';
      // 进入下一层决策树
      backtrack(board, row + 1);
      // 撤销选择
      board[row][col] = '.';
    }
  }

  /**
   * 当前决策树节点是否能放置皇后
   *
   * @param board 最新的树
   * @param row   当前行
   * @param col   当前列
   */
  public boolean valid(char[][] board, int row, int col) {
    int n = board.length;
    // 检查col列是否有皇后冲突
    for (char[] chars : board) {
      if (chars[col] == 'Q') {
        return false;
      }
    }
    // 检查右上方是否有皇后冲突，右上方的意思是右上角的整个斜线
    for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }
    // 检查左上方是否有皇后冲突，左上方的意思是左上角的整个斜线
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int i = new LeeCode0052().totalNQueens(4);
    System.out.println(i);
  }
}
