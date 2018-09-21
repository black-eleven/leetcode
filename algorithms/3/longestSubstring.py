#!/usr/bin/env python
# -*- coding:utf-8 -*-

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        max_length = 0
        j = 0
        i = 0
        tmp_length = 0
        chars = set()
        while i < len(s):
            if s[i] not in chars:
                chars.add(s[i])
                i += 1
                tmp_length += 1
                if max_length < tmp_length:
                    max_length = tmp_length
            else:
                tmp_length -= 1
                chars.remove(s[j])
                j += 1
        return max_length

if __name__ == "__main__":
    sl = Solution()
    #print sl.lengthOfLongestSubstring("")
    #print sl.lengthOfLongestSubstring("abcabcbb")
    #print sl.lengthOfLongestSubstring("rzglxknrqhipqrivdgixxtutzfwejbidaqoyddrtkzlaqvxubhrablwcssgctqfvhvvman")
    print sl.lengthOfLongestSubstring("a")
