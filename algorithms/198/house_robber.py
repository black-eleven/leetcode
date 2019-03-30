# -*- coding: utf-8 -*-

class Solution1(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        if len(nums) <= 2:
            return max(nums)
        rob_cur = self.rob(nums[2:]) + nums[0]
        no_rob_cur = self.rob(nums[1:])
        return max(rob_cur, no_rob_cur)

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        if len(nums) <= 2:
            return max(nums)
        dp = [nums[0], max(nums[0], nums[1])]
        max_rob = 0
        for i in range(2, len(nums)):
            rob_cur_max = nums[i] + max(dp[:i-1])
            no_rob_cur_max = max(dp[:i])
            dp.append(max(rob_cur_max, no_rob_cur_max))
        return dp.pop()

if __name__ == "__main__":
    s = Solution()
    print s.rob([1,2,3,1])
    print s.rob([2,7,9,3,1])
    print s.rob([1,3,1])
    print s.rob([2,1,1,2])
