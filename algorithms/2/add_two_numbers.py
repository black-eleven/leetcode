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
        if not l1:
            return l2
        if not l2:
            return l1
        first_val = l1.val + l2.val
        lr_result = ListNode(first_val % 10)
        tmp_result = lr_result
        jw = first_val / 10
        pre_node = None
        while l1.next and l2.next:
            l1 = l1.next
            l2 = l2.next
            pre_node = tmp_result
            tmp = l1.val + l2.val + jw
            tmp_result = ListNode(tmp%10)
            pre_node.next = tmp_result
            jw = tmp / 10
        return lr_result

def init_list(vlist):
    if not vlist:
        return None
    root = ListNode(vlist[0])
    tmp = root
    for v in vlist[1:]:
        next_node = ListNode(v)
        tmp.next = next_node
        tmp = tmp.next
    return root

def print_list(l):
    while l:
        print l.val
        l = l.next

if __name__ == "__main__":
    sl = Solution()
    l1 = init_list([2, 4, 3])
    print_list(l1)
    l2 = init_list([5, 6, 4])
    print_list(l2)
    print_list(sl.addTwoNumbers(l1, l2))
