import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LeetCode0003 {

  public int lengthOfLongestSubstring(String s) {
    // 处理边界情况
    if(s.length() == 1){
      return 1;
    }
    // 记录当前窗口内所有的值，存储的规则是某个值在窗口内的数量，在这个题目中，那么最终结果value只能是1
    LinkedHashMap<Character, Integer> characters = new LinkedHashMap<>();
    // 定义窗口左右的指针
    int left = 0, right = 0;
    // 更新滑动窗口右侧的值
    Character rightNewestValue = null;
    // 右指针向右移动，一直到边界
    while (right < s.length()){
      // 当前右指针移动到的位置所对应的值
      char nowValue = s.charAt(right);
      // 拿到值之后移动右指针
      right ++;
      // 更新滑动窗口右侧的值
      rightNewestValue = nowValue;
      // 更新LinkedHashMap的值，用于下面判断或者移动左边的指针
      // 如果当前窗口内，包含的该nowValue值得数量>1，则收缩左边界
      while(characters.)
    }


  }

  public static void main(String[] args) {

  }
}
