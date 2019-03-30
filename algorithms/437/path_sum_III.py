# -*- coding: utf-8 -*-

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):

    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        return self.pathTmpSum(root, sum, sum)

    def pathTmpSum(self, root, sum, sum_tmp):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        if root == None:
            return 0
        a = 1 if root.val == sum_tmp else 0
        print root.val, sum_tmp

        return self.pathTmpSum(root.left, sum, sum) + self.pathTmpSum(root.left, sum, sum_tmp-root.val) + self.pathTmpSum(root.right, sum, sum) + self.pathTmpSum(root.right, sum, sum_tmp-root.val) + a

def init_tree(nums):
    i = 0
    root = TreeNode(nums[0])
    tmp = root
    nodes = [root]
    node_i = 0
    while True:
        i += 1
        if i >= len(nums):
            break
        if nums[i] != None:
            left_node = TreeNode(nums[i])
            nodes.append(left_node)
        else:
            left_node = None
        i += 1
        if i >= len(nums):
            break
        if nums[i] != None:
            right_node = TreeNode(nums[i])
            nodes.append(right_node)
        else:
            right_node = None
        tmp.left = left_node
        tmp.right = right_node
        node_i += 1
        tmp = nodes[node_i]
    return root

def print_tree(root):
    if root == None:
        return
    print_tree(root.left)
    print root.val
    print_tree(root.right)

if __name__ == '__main__':
    #root = [10, 5, -3, 3, 2, None, 11, 3, -2, None, 1]
    root = [1, None,2, None, 3, None, 4, None, 5]
    tree = init_tree(root)
    print_tree(tree)
    s = Solution()
    print s.pathSum(tree, 3)
