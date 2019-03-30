# -*- coding: utf-8 -*-

class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        if num == 0:
            return [0]
        dp = [0, 1] + [None] * (num-1)
        div = 1
        for i in range(2, num+1):
            if i >= div*2:
                div = div * 2
            dp[i] = dp[i%div] + dp[i/div]
        return dp

if __name__ == "__main__":
    s = Solution()
    print s.countBits(2)
