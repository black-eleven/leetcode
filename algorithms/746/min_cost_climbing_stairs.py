# -*- coding: utf-8 -*-
import sys

class Solution1(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        if len(cost) <= 1: return 0
        one_step = self.minCostClimbingStairs(cost[1:]) + cost[0]
        two_step = self.minCostClimbingStairs(cost[2:]) + cost[1]
        return min(one_step, two_step)


class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        last_step_one_min = cost[1]
        last_step_two_min = cost[0]
        for c in cost[2:]:
            c_min = min(last_step_two_min, last_step_one_min)
            last_step_two_min = last_step_one_min
            last_step_one_min = c_min + c
        return min(last_step_one_min, last_step_two_min)

if __name__ == "__main__":
    s = Solution()
    print s.minCostClimbingStairs([1, 100, 1, 1, 1, 100, 1, 1, 100, 1])
    print s.minCostClimbingStairs([10, 15, 20])
