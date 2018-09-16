/**
* Given a binary tree, return the tilt of the whole tree.
*
* The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
*
* The tilt of the whole tree is defined as the sum of all nodes' tilt.
*
* Example:
* Input:
*          1
*        /   \
*       2     3
* Output: 1
* Explanation:
* Tilt of node 2 : 0
* Tilt of node 3 : 0
* Tilt of node 1 : |2-3| = 1
* Tilt of binary tree : 0 + 0 + 1 = 1
* Note:
*
* 1. The sum of node values in any subtree won't exceed the range of 32-bit integer.
* 2. All the tilt values won't exceed the range of 32-bit integer.
*
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode(int x) { val = x; }
* }
*/

import java.util.*;

public class Solution {
    public int findTilt(TreeNode root) {
      if(root == null){
        return 0;
      }
      List<Integer> tiltList = new ArrayList<Integer>();
      TreeNode sumTree = new TreeNode(0);
      order(root, sumTree, tiltList);
      int sum = 0;
      for(Integer i : tiltList){
        sum += i;
      }
      return sum;
    }

    public void order(TreeNode root, TreeNode sumTree, List<Integer> tiltList){
      if(root.left != null){
        sumTree.left = new TreeNode(0);
        order(root.left, sumTree.left, tiltList);
      }

      if(root.right != null){
        sumTree.right = new TreeNode(0);
        order(root.right, sumTree.right, tiltList);
      }

      int left = root.left==null?0:sumTree.left.val;
      int right = root.right==null?0:sumTree.right.val;
      sumTree.val = left + right + root.val;
      int sumLeft = root.left==null?0:sumTree.left.val;
      int sumRight = root.right==null?0:sumTree.right.val;
      tiltList.add(Math.abs(sumLeft-sumRight));
    }

    public static void main(String[] args){
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      // root.left.left = new TreeNode(4);
      // root.left.right = new TreeNode(5);
      Solution s = new Solution();
      System.out.println(s.findTilt(root));
    }
}


class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
