import java.util.LinkedList;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LeetCode0014 {

  public String longestCommonPrefix(String[] strs) {
    if(strs.length == 1){
      return strs[0];
    }
    int point = 0;

    StringBuilder commonStr = new StringBuilder("");

    boolean scan = strs.length > 1;
    while (scan && strs[0].length() > 0 && point < strs[0].length()) {
      commonStr.append(strs[0].charAt(point));
      for (String str : strs) {
        if(commonStr.length() <= point){
          scan = false;
          break;
        }
        if(str.length() < commonStr.length() ){
          scan = false;
          commonStr.deleteCharAt(point);
          break;
        }
        if(commonStr.charAt(point) == str.charAt(point)){
          continue;
        }
        scan = false;
        commonStr.deleteCharAt(point);
      }
      point++;
    }

    return commonStr.toString();
  }

  public static void main(String[] args) {
    System.out.println(new LeetCode0014().longestCommonPrefix(new String[]{
            "flower","flower","flower","flower"
    }));
  }
}
