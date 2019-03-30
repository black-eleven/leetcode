# -*- coding: utf-8 -*-

class NumArray(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        if not nums:
            return
        self.sums = [nums[0]]
        for i in range(1, len(nums)):
            self.sums.append(self.sums[i-1] + nums[i])

    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """
        return self.sums[j] - (self.sums[i-1] if i > 0 else 0)

if __name__ == "__main__":
    obj = NumArray([-2, 0, 3, -5, 2, -1])
    print obj.sumRange(0, 2)
    print obj.sumRange(2, 5)
    print obj.sumRange(0, 5)
