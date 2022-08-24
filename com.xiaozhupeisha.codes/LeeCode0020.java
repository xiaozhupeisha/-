import java.util.Stack;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
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
