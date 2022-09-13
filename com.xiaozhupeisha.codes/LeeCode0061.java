
/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class LeeCode0061 {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) return head;
    ListNode cur = head;
    // 统计链表长度：
    int len = 0;
    while (cur != null) {
      len++;
      cur = cur.next;
    }
    // 对k化简：
    k %= len;
    if (k == 0) return head;
    // 快指针 fast 先走k步：
    ListNode fast = head;
    while (k > 0) {
      fast = fast.next;
      k--;
    }
    // 快慢指针再一起同步前进，直至fast走到尾节点停：
    ListNode slow = head;
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    // 此时的慢指针slow的下一个节点就是旋转后的新头，原尾节点fast串连到老头head上：
    ListNode dummy = slow.next;
    slow.next = null;
    fast.next = head;
    return dummy;
  }


  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    listNode1.next = listNode2;

    ListNode listNode = new LeeCode0061().rotateRight(listNode1, 2);
    while (listNode != null){
      System.out.println(listNode.val);
      listNode = listNode.next;
    }
  }

  public static class ListNode {
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

}
