import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class LeeCode0020 {

  public boolean isValid(String s) {
    Stack<Character> characters = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '{' || c == '[' || c == '(') {
        characters.push(c);
      } else {
        if (!characters.isEmpty() && characters.peek() == leftOf(c)) {
          characters.pop();
        }else{
          return false;
        }
      }
    }
    return characters.isEmpty();
  }

  char leftOf(char c) {
    if (c == '}') return '{';
    if (c == ')') return '(';
    return '[';
  }
}
