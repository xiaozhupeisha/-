/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 */
public class LeetCode0009 {

  public boolean isPalindrome(int x) {
    if(x < 0){
      return false;
    }
    String xx = String.valueOf(x);

    // 使用双指针，两头对比，兼容奇偶数情况
    int l = 0, r = xx.length() - 1;
    while (l<=r){
      if(xx.charAt(l) == xx.charAt(r)){
        l++;
        r--;
        continue;
      }
      return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(new LeetCode0009().isPalindrome(1));
  }
}
