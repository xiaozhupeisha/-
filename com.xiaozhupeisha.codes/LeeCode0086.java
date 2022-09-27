/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class LeeCode0086 {
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
    listNode.next = new ListNode(4);
    listNode.next.next = new ListNode(3);
    listNode.next.next.next = new ListNode(2);
    listNode.next.next.next.next = new ListNode(5);
    listNode.next.next.next.next.next = new ListNode(2);
    return listNode;
  }

  public ListNode partition(ListNode head, int x) {
    ListNode small = new ListNode(-1);
    ListNode large = new ListNode(-1);

    ListNode smallHead = small;
    ListNode largeHead = large;

    while (head != null) {
      if(head.val < x){
        small.next = head;
        small = small.next;
      }else{
        large.next = head;
        large = large.next;
      }
      head = head.next;
    }
    large.next = null;
    small.next = largeHead.next;
    return smallHead.next;
  }

  public static void main(String[] args) {
    LeeCode0086 leeCode0086 = new LeeCode0086();
    ListNode init = leeCode0086.init();
    ListNode partition = leeCode0086.partition(init, 3);
    System.out.println(partition);
  }

}
