#!/usr/bin/env python
# -*- coding:utf-8 -*-

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
		"""
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        lr_result = new ListNode(0)
        jw = 0
        for l1_one, l2_one in zip(l1, l2):
            tmp = l1_one + l2_one + jw
            if tmp > 10:
                lr.val = tmp - 10
                jw = 1
            else:
                lr = tmp
                jw = 0
            lr.next = new ListNode(0)

if __name__ == "__main__":
    sl = Solution()
    l1 = ListNode()
    sl.addTwoNumbers()
