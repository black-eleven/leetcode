#!/usr/bin/env python
# -*- coding:utf-8 -*-

class Solution(object):
    def judge(self, str):
        for index, one in enumerate(str):
            for k in str[index+1:]:
                if one == k:
                    return False
        return True

    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = len(s)
        char_nums = {}
        for one in s:
            if not one in char_nums:
                char_nums[one] = 0
            else:
                char_nums[one] += 1

        print char_nums

        for i in xrange(length, 0, -1):
            for j in xrange(0, length-i+1):
                tmp = s[0:j-1]+s[j+i+1:]
                if self.judge(tmp):
                    return i
        return 0

if __name__ == "__main__":
    sl = Solution()
    print sl.lengthOfLongestSubstring("")
    print sl.lengthOfLongestSubstring("abcabcbb")
    print sl.lengthOfLongestSubstring("rzglxknrqhipqrivdgixxtutzfwejbidaqoyddrtkzlaqvxubhrablwcssgctqfvhvvman")
