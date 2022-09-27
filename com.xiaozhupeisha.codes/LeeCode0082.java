/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class LeeCode0082 {
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

  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode pre = dummy, current = dummy.next;
    while (current != null) {
      ListNode next = current.next;
      while (next != null && current.val == next.val) {
        next = next.next;
      }
      if (next != current.next) {
        pre.next = next;
        current = next;
      } else {
        pre = current;
        current = next;
      }
    }
    return dummy.next;
  }

}
