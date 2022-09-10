/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class LeeCode0059 {
  public int lengthOfLastWord(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int word = 0;
    int j = s.length() - 1;
    while (j < s.length()) {
      if (!String.valueOf(s.charAt(j)).equals(" ")) {
        break;
      }
      j--;
    }
    while (j < s.length() && j >= 0) {
      if (String.valueOf(s.charAt(j)).equals(" ")) {
        break;
      }
      word++;
      j--;
    }
    return word;
  }

  public static void main(String[] args) {
    int hello_world = new LeeCode0059().lengthOfLastWord("a");
    System.out.println(hello_world);
  }
}
