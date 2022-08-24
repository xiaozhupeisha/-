import java.util.LinkedHashMap;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LeeCode0003 {

  public int lengthOfLongestSubstring(String s) {
    // 处理边界情况
    if(s.length() == 1){
      return 1;
    }
    // 记录当前窗口内所有的值，存储的规则是某个值在窗口内的数量，在这个题目中，那么最终结果value只能是1
    LinkedHashMap<Character, Integer> characters = new LinkedHashMap<>();
    // 定义窗口左右的指针
    int left = 0, right = 0;
    // 定义窗口最大的情况
    int maxLength = 0;
    // 右指针向右移动，一直到边界
    while (right < s.length()){
      // 当前右指针移动到的位置所对应的值
      char nowValue = s.charAt(right);
      // 更新LinkedHashMap的值，用于下面判断或者移动左边的指针
      if(!characters.containsKey(nowValue)){
        characters.put(nowValue, 1);
      }else{
        characters.put(nowValue, characters.get(nowValue) + 1);
      }
      // 如果当前窗口内，包含的该nowValue值，则收缩左边界
      while(characters.get(nowValue) > 1){
        // 如果左边指针移动经过了当前重复的值，则修改LinkedHashMap里面该重复值数量
        if(s.charAt(left) == nowValue){
          characters.put(nowValue, characters.get(nowValue) - 1);
        }else{
          characters.put(s.charAt(left), characters.get(s.charAt(left)) - 1);
        }
        // 左边指针右移
        left++;
      }
      // 拿到值之后移动右指针
      right ++;
      maxLength = Math.max(maxLength, right - left);
    }
    System.out.println("左边指针位置" + left);
    System.out.println("右边指针位置" + right);
    return maxLength;
  }

  public static void main(String[] args) {
    int i = new LeeCode0003().lengthOfLongestSubstring("tmmzuxt");
    System.out.println(i);
  }
}
