import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 */
public class LeeCode0095 {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public List<TreeNode> generateTrees(int n) {
    return build(1, n);
  }

  public LinkedList<TreeNode> build(int l, int r) {
    LinkedList<TreeNode> result = new LinkedList<>();
    // base-case
    if (l > r) {
      result.add(null);
      return result;
    }
    for (int i = l; i <= r; i++) {
      LinkedList<TreeNode> left = build(l, i - 1);
      LinkedList<TreeNode> right = build(i + 1, r);

      for (TreeNode leftTree : left) {
        for (TreeNode rightTree : right) {
          TreeNode treeNode = new TreeNode(i);
          treeNode.left = leftTree;
          treeNode.right = rightTree;
          result.add(treeNode);
        }
      }
    }
    return result;
  }
}
