/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class LeeCode0083 {
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
    listNode.next.next = new ListNode(2);
    listNode.next.next.next = new ListNode(3);
    listNode.next.next.next.next = new ListNode(4);
    listNode.next.next.next.next.next = new ListNode(5);
    return listNode;
  }

  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    while (dummy.next != null) {
      if (dummy.val == dummy.next.val) {
        dummy.next = dummy.next.next;
        continue;
      }
      dummy = dummy.next;
    }
    return head;
  }

  public static void main(String[] args) {
    LeeCode0083 leeCode0082 = new LeeCode0083();
    ListNode init = leeCode0082.init();
    ListNode listNode = leeCode0082.deleteDuplicates(init);
    System.out.println(listNode);
  }

}
