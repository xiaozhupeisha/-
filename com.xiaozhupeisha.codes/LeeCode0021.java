import java.util.Stack;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LeeCode0021 {

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // 先定义结果
    ListNode dummy = new ListNode(-1);
    ListNode p;
    p = dummy.next; // 定义节点，指向虚拟节点的下一个，常规操作

    // 得到2个链表的头
    ListNode p1 = list1, p2 = list2;

    // 之所以用&&，是因为合并的话，如果一个太长了，那么它后面的值肯定比短的大
    while (p1 != null && p2 != null) {
      if (p1.val < p2.val) {
        p.next = p1;
        p1 = p1.next;
      }else{
        p.next = p2;
        p2 = p2.next;
      }
      // p指针是需要移动的
      p = p.next;
    }

    // 如果2个链表长度不等，则把没拉链完的给他补充到后面
    if(p1 != null) p.next = p1;
    if(p2 != null) p.next = p2;

    // 返回虚拟节点的下一个节点，-1不要
    return dummy.next;
  }

}
