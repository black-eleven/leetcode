# -*- coding: utf-8 -*-


class Solution(object):
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        i = 0
        ret = 1
        for j, element in enumerate(arr):
            if element > arr[i]:
                if arr[i] == j-1:
                    ret += 1
                i = j
        return ret


if __name__ == "__main__":
    s = Solution()
    print s.maxChunksToSorted([4,3,2,1,0]) # 1
    print s.maxChunksToSorted([1,0,2,3,4]) # 4
    print s.maxChunksToSorted([1,2,0,3]) # 2
    print s.maxChunksToSorted([0, 2, 1]) # 2
    print s.maxChunksToSorted([0]) # 1
    print s.maxChunksToSorted([0, 1]) # 2
