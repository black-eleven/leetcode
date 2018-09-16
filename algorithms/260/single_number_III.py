#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ret = set()
        for n in nums:
            if n in ret:
                ret.remove(n)
            else:
                ret.add(n)
        return list(ret)

if __name__ == '__main__':
    s = Solution()
    print(s.singleNumber([1,2,1,5,2,9]))
