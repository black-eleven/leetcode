#!/usr/bin/env python
# -*- coding:utf-8 -*-

class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        tmp = 0
        if x == 0:
            return True

        typeConv = [1,0]
        type = 0
        while x >= tmp and x != 0:
            if tmp == x and type == 0:
                return True
            elif tmp == x/10 and type == 1:   
                return True

            type = typeConv[type]
            reminder = x % 10
            x = x / 10
            tmp = tmp * 10 + reminder
        return False


if __name__ == "__main__":
    sl = Solution()
    print sl.isPalindrome(1)
    
