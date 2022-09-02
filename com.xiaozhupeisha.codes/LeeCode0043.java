import java.util.LinkedList;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 */
public class LeeCode0043 {
  public String multiply(String num1, String num2) {
    int m = num1.length(), n = num2.length();
    int[] result = new int[m + n];

    // 从个位数开始乘
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        int r = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        int index1 = i + j, index2 = i + j + 1;
        // 将result的当前index2加上本次的乘积
        int sum = result[index2] + r;
        result[index2] = sum % 10;
        result[index1] += sum / 10;
      }
    }
    // 结果前缀可能存的 0（未使用的位）
    int i = 0;
    while (i < result.length && result[i] == 0) {
      i++;
    }

    StringBuilder strRes = new StringBuilder();
    while (i < result.length) {
      strRes.append(result[i]);
      i++;
    }
    return strRes.toString().length() == 0 ? "0" : strRes.toString();
  }

  public static void main(String[] args) {
    String multiply = new LeeCode0043().multiply("123", "456");
    System.out.println(multiply);
  }
}
