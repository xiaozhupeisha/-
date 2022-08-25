import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class LeeCode0023 {
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

  public ListNode mergeKLists(ListNode[] lists) {
    // 定义虚拟节点
    ListNode dummy = new ListNode(-1);
    // 得到虚拟节点
    ListNode p = dummy;
    // 定义优先级队列
    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));

    // 放入3个头节点
    for (ListNode listNode : lists) {
      if (listNode != null) {
        priorityQueue.add(listNode);
      }
    }

    // 优先级队列为空则跳出循环
    while (!priorityQueue.isEmpty()) {
      // 获取最小的值
      ListNode poll = priorityQueue.poll();
      // 放到虚拟节点的后面
      p.next = poll;
      // 补充出走的节点
      if (poll.next != null) {
        priorityQueue.add(poll.next);
      }
      // 移动虚拟节点的位置
      p = p.next;
    }

    return dummy.next;
  }
}
