# -*- coding: utf-8 -*-

class Solution1(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 1
        if n == 2:
            return 2
        return self.climbStairs(n-1) + self.climbStairs(n-2)


class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        one_step = 1
        two_step = 0
        for i in range(n-1):
            tmp = one_step
            one_step = one_step + two_step
            two_step = tmp
        return one_step + two_step

if __name__ == "__main__":
    s = Solution()
    print s.climbStairs(6)
