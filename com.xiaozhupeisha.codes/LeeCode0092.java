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
    LeeCode0092 leeCode0086 = new LeeCode0092();
    ListNode init = leeCode0086.init();
    ListNode partition = leeCode0086.partition(init, 3);
    System.out.println(partition);
  }

}
