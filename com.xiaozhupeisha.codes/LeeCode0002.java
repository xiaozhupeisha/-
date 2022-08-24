
/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 */
public class LeeCode0002 {
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

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // 拿到2个链表的初始化指针
    ListNode p1 = l1, p2 = l2;

    // 初始化节点的头，防止节点错乱
    ListNode dummy = new ListNode(-1);

    // 新节点的指针，由它来构建新的链表，最终返回的则是初始化的dummy
    ListNode p = dummy;

    // 用来记录每次循环生成的进位，0或者1
    int carry = 0;
    while (p1 != null || p2 != null || carry > 0) {
      // 本次2个链表节点的相加结果，首先应该等于上次的进位，因为进位不能丢掉
      int addResult = carry;

      if (p1 != null) {
        // 本次2个链表节点的相加结果，处于 0-18 之间
        addResult += p1.val;
        p1 = p1.next;
      }
      if (p2 != null) {
        // 本次2个链表节点的相加结果，处于 0-18 之间
        addResult += p2.val;
        p2 = p2.next;
      }
      // 计算出本次的进位，其实就是➗10算整数
      carry = addResult / 10;
      // 计算出本次的值，其实就是➗10算余数
      addResult = addResult % 10;

      // 相加结束后，构建新的链表的本个节点
      p.next = new ListNode(addResult);
      // 移动指针到新的节点，老的节点已经在dummy里面了
      p = p.next;
    }
    return dummy.next;
  }


  public static void main(String[] args) {

  }
}
