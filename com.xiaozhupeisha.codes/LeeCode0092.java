/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class LeeCode0092 {
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

  public ListNode init() {
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(2);
    listNode.next.next = new ListNode(3);
    listNode.next.next.next = new ListNode(4);
    listNode.next.next.next.next = new ListNode(5);
    return listNode;
  }

  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (left == 1) {
      return reverse(head, right);
    }
    head.next = reverseBetween(head.next, left - 1, right - 1);
    return head;
  }

  ListNode successor = null;

  ListNode reverse(ListNode head, int n) {
    // base-case
    if (n == 1) {
      successor = head.next;
      return head;
    }
    ListNode last = reverse(head.next, n - 1);
    head.next.next = head;
    head.next = successor;
    return last;
  }

  public static void main(String[] args) {
    LeeCode0092 leeCode0086 = new LeeCode0092();
    ListNode init = leeCode0086.init();
    ListNode partition = leeCode0086.reverseBetween(init, 2, 4);
    System.out.println(partition);
  }

}
