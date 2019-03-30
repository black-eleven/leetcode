# -*- coding: utf-8 -*-

class Solution(object):
    def nextGreaterElement(self, findNums, nums):
        """
        :type findNums: List[int]
        :type nums: List[int]
        :rtype: List[int]
        """
        r_nums = []
        for index, f_num in enumerate(findNums):
            tmp = -1
            for num in nums[index:]:
                if num > f_num:
                    tmp = num
                    break
            r_nums.append(tmp)
        return r_nums

if __name__ == '__main__':
    s = Solution()
    print s.nextGreaterElement([4, 1, 2], [1, 3, 4, 2])
