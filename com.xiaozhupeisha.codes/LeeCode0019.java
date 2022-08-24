import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class LeeCode0019 {
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

  public ListNode removeNthFromEnd(ListNode head, int n) {
    // 虚拟头结点
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    // 快指针
    ListNode p1 = dummy;
    // 快指针先走N步
    for (int i = 0; i < n + 1; i++) {
      p1 = p1.next;
    }
    // 慢指针
    ListNode p2 = dummy;

    // p1 和 p2 同时走 总长度 - N 步，这时候P到达了指定位置了
    while (p1 != null) {
      p2 = p2.next;
      p1 = p1.next;
    }

    // 删除p2的下一个节点
    p2.next = p2.next.next;

    return dummy.next;
  }

}
