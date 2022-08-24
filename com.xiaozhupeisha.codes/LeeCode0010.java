/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 */
public class LeeCode0010 {

  /**
   * s 和 p 相互匹配的过程大致是，两个指针 i, j 分别在 s 和 p 上移动，如果最后两个指针都能移动到字符串的末尾，那么就匹配成功，反之则匹配失败。
   * 正则表达算法问题只需要把住一个基本点：看 s[i] 和 p[j] 两个字符是否匹配，一切逻辑围绕匹配/不匹配两种情况展开即可。
   * 动态规划算法的核心就是「状态」和「选择」，「状态」无非就是 i 和 j 两个指针的位置，「选择」就是模式串的 p[j] 选择匹配几个字符。
   */
  public boolean isMatch(String s, String p) {




    return true;
  }

  public static void main(String[] args) {
    System.out.println(new LeeCode0010().isMatch("aaa", "a*"));
  }
}
