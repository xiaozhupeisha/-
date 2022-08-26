/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class LeeCode0025 {
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

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) return null;

    // 区间 [a, b) 包含 k 个待反转元素
    ListNode a, b;
    // 初始等于第一个节点head
    a = b = head;
    for (int i = 0; i < k; i++) {
      // 如果长度不够了，则代表这一段链表的长度小于k，不需要翻转了，直接返回
      if (b == null) return head;
      // 移动b的指针，将a-b组成一个k长度的链表
      b = b.next;
    }
    // 反转前 k 个元素
    ListNode newHead = reverse(a, b);
    // 递归反转后续链表并连接起来
    a.next = reverseKGroup(b, k);
    // 返回最新的头结点
    return newHead;
  }

  /**
   * 反转区间 [a, b) 的元素，注意是左闭右开
   */
  public ListNode reverse(ListNode a, ListNode b) {
    ListNode pre = null;// 初始化在a的前面，是空
    ListNode cu = a;// 初始化是头结点
    ListNode next = b;// 初始化是头结点

    // 循环开始的标志是中间节在这一段k长度的链接最左边
    // 循环终止的标志是中间节点到了这一段k长度的链接最右边
    while (cu != b){
      // next向右移动一格
      next = cu.next;
      // 将cu前面的元素接在cu后面
      cu.next = pre;
      // 移动原本cu前面的元素的指针，移动到cu在的位置
      pre = cu;
      // 移动原本cu元素的指针，移动到cu在的位置后面
      cu = next;
    }
    // 返回新的头jied
    return pre;
  }
}
