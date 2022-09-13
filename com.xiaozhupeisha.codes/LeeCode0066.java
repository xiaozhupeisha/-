import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class LeeCode0066 {

  public int[] plusOne(int[] digits) {
    int add = 1;
    int[] result = new int[digits.length + 1];
    Arrays.fill(result, 0);
    for (int i = digits.length - 1; i >= 0; i--) {
      int val = digits[i] + add;
      if (val >= 10) {
        result[i + 1] = val % 10;
        digits[i] = val % 10;
      } else {
        add = 0;
        result[i + 1] = val;
        digits[i] = val;
      }
    }
    if (add == 1) {
      result[0] = 1;
      return result;
    }else{
      return digits;
    }
  }

  public static void main(String[] args) {
    int[] digits = {1, 2};
    int[] ints = new LeeCode0066().plusOne(digits);
    for (int anInt : ints) {
      System.out.println(anInt);
    }
  }

}
