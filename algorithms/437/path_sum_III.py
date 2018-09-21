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
        pass

def init_tree(nums):
    i = 0
    root = TreeNode(nums[0])
    tmp = root
    while True:
        left_node = TreeNode(nums[i])
        right_node = TreeNode(nums[i])
        tmp = 


if __name__ == '__main__':
    root = [10, 5, -3, 3, 2, None, 11, 3, -2, None, 1]
    init_tree(root)
    s = Solution()
    #s.pathSum()
