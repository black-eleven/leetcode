#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        median1 = None
        pre1 = 0
        end1 = len(nums1)
        median2 = None
        pre2 = 0
        end2 = len(nums2)
        if end1 == 1 and end2 == 1:
            return float(nums1[0]+nums2[0])/2
        if end1 ==  0:
            return self.get_median(nums2)
        if end2 ==  0:
            return self.get_median(nums1)
        if nums1[end1-1] < nums2[0]:
            nums1.extend(nums2)
            return self.get_median(nums1)
        if nums1[0] >  nums2[end2-1]:
            nums2.extend(nums1)
            return self.get_median(nums2)
        while (end1-pre1) > 1 or (end2-pre2) > 1:
            median1 = self.get_median(nums1[pre1:end1])
            median2 = self.get_median(nums2[pre2:end2])
            if median1 > median2:
                end1 = (pre1+end1)/2 + (pre1-end1)%2
                pre2 = (pre2+end2)/2
            elif median1 < median2:
                pre1 = (pre1+end1)/2
                end2 = (pre2+end2)/2 + (pre2-end2)%2
            else:
                break
        if median1 != median2:
            return (median1+median2)/2
        return median1

    def get_median(self, nums):
        length = len(nums)
        _type = length%2
        if _type:
            return float(nums[(length-1)/2])
        else:
            return float(nums[(length-1)/2+1]+nums[(length-1)/2])/2

if __name__  == '__main__':
    s = Solution()
    print s.findMedianSortedArrays([1, 2], [-1, 3])
