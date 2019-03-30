# -*- coding: utf-8 -*-

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_sum = nums[0]
        include_end_point_sum = nums[0]
        for i in range(1, len(nums)):
            cur_max_sum = include_end_point_sum + nums[i] if include_end_point_sum > 0 else nums[i]
            max_sum = max(max_sum, cur_max_sum)
            include_end_point_sum = cur_max_sum
        return max_sum

if __name__ == "__main__":
    s = Solution()
    print s.maxSubArray([-2,1,-3,4,-1,2,1,-5,4])
