import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class LeeCode0094 {
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

  LinkedList<Integer> result = new LinkedList<>();
  public List<Integer> inorderTraversal(TreeNode root) {
    traverse(root);
    return result;
  }

  public void traverse(TreeNode root){
    if(root == null){
      return;
    }
    // 前序遍历
    traverse(root.left);
    // 中序遍历
    result.add(root.val);
    // 后序遍历
    traverse(root.right);
  }

}
