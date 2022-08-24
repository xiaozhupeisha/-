import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 */
public class LeeCode0017 {

  private String letterMap[] = {
          " ",    //0
          "",     //1
          "abc",  //2
          "def",  //3
          "ghi",  //4
          "jkl",  //5
          "mno",  //6
          "pqrs", //7
          "tuv",  //8
          "wxyz"  //9
  };

  private ArrayList<String> res;

  public List<String> letterCombinations(String digits) {

    res = new ArrayList<String>();
    if (digits.equals(""))
      return res;

    findCombination(digits, 0, "");
    return res;
  }

  private void findCombination(String digits, int index, String s) {

    // 2 == 23.length
    if (index == digits.length()) {
      res.add(s);// "ad"
      return;
    }

    char c = digits.charAt(index);// 2 -> 3
    String letters = letterMap[c - '0'];// abc -> def
    for (int i = 0; i < letters.length(); i++) {
      // findCombination(23, 1, "" + a);
      //
      // findCombination(23, 2, a + d);
      // return ad
      findCombination(digits, index + 1, s + letters.charAt(i));
    }

    return;
  }

  public static void main(String[] args) {
    List<String> strings = new LeeCode0017().letterCombinations("23");
    System.out.println(strings);
  }
}
