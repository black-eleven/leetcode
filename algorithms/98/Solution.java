/**
* Given a binary tree, determine if it is a valid binary search tree (BST).
*
* Assume a BST is defined as follows:
*
* The left subtree of a node contains only nodes with keys less than the node's key.
* The right subtree of a node contains only nodes with keys greater than the node's key.
* Both the left and right subtrees must also be binary search trees.
* Example 1:
*    2
*   / \
*  1   3
* Binary tree [2,1,3], return true.
* Example 2:
*    1
*   / \
*  2   3
* Binary tree [1,2,3], return false.
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode(int x) { val = x; }
* }
*/



public class Solution{
  public static void main(String[] args){
    Solution s = new Solution();
    // TreeNode root = new TreeNode(2147483647);
    // [0,-2147483648,2147483647]
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(-2147483648);
    root.right = new TreeNode(2147483647);
    System.out.println(s.isValidBST(root));
  }

  public boolean isValidBST(TreeNode root) {
    return isValidBSTRecursive(root, Long.MAX_VALUE, Long.MIN_VALUE);
  }

  public boolean isValidBSTRecursive(TreeNode root, long upper, long down){
    if(root == null){
      return true;
    }

    if(root.val <= down || root.val >= upper){
      return false;
    }

    if(!isValidBSTRecursive(root.left, root.val, down)){
      return false;
    }

    if(!isValidBSTRecursive(root.right, upper, root.val)){
      return false;
    }

    return true;
  }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
