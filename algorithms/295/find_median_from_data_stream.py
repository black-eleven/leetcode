#!/usr/bin/env python
# -*- coding: utf-8 -*-

class MedianFinder(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.median_list = []
        self.median = None
        self.odd = False
        self.large_list = []
        self.less_list = []

    def addNum(self, num):
        """
        :type num: int
        :rtype: void
        """
        if len(self.median_list) == 3:
            if self.median_list[0] > num:
                large = self.findLarge(num)
                self.median_list.insert(0, large)
            elif self.median_list[0] <= num < self.median_list[1]:
                self.median_list.insert(1, num)
            elif self.median_list[1] <= num < self.median_list[2]:
                self.median_list.insert(2, num)
            else:
                less = self.findLess(num)
                self.median_list.append(less)
            self.median = float(self.median_list[1]+self.median_list[2])/2
        elif len(self.median_list) == 4:
            if self.median_list[0] > num:
                self.median_list.insert(0, num)
            elif self.median_list[0] <= num < self.median_list[1]:
                self.median_list.insert(1, num)
            elif self.median_list[1] <= num < self.median_list[2]:
                self.median_list.insert(2, num)
            elif self.median_list[2] <= num < self.median_list[3]:
                self.median_list.insert(3, num)
            else:
                self.median_list.append(num)
            self.insertLarge(self.median_list[4])
            self.insertLess(self.median_list[0])
            self.median_list = self.median_list[1:4]
            self.median = float(self.median_list[1])
        elif len(self.median_list) == 2:
            if self.median_list[0] > num:
                self.median_list.insert(0, num)
            elif self.median_list[0] <= num < self.median_list[1]:
                self.median_list.insert(1, num)
            else:
                self.median_list.append(num)
            self.median = float(self.median_list[1])
        elif len(self.median_list) == 0:
            self.median_list.append(num)
            self.median = float(num)
        elif len(self.median_list) == 1:
            if num > self.median:
                self.median_list.append(num)
            else:
                self.median_list.insert(0, num)
            self.median = float(num+self.median)/2
        self.odd = not self.odd

    def findLess(self, num):
        if not self.large_list or num <= self.large_list[0]:
            return num
        ret = self.large_list[0]
        self.large_list[0] = num
        i = 0
        while i < len(self.large_list) and (2*i+2) < len(self.large_list):
            if self.large_list[i] <= self.large_list[2*i+1] and self.large_list[i] <= self.large_list[2*i+2]:
                break
            elif self.large_list[2*i+1] < self.large_list[i] and self.large_list[2*i+1] < self.large_list[2*i+2]:
                tmp = self.large_list[i]
                self.large_list[i] = self.large_list[2*i+1]
                self.large_list[2*i+1] = tmp
                i = 2*i+1
            else:
                tmp = self.large_list[i]
                self.large_list[i] = self.large_list[2*i+2]
                self.large_list[2*i+2] = tmp
                i = 2*i+2
        if (2*i+2) == len(self.less_list):
            if self.less_list[2*i+1] < self.less_list[i]:
                tmp = self.less_list[i]
                self.less_list[i] = self.less_list[2*i+1]
                self.less_list[2*i+1] = tmp
        return ret

    def insertLarge(self, num):
        self.large_list.append(num)
        i = len(self.large_list)
        while i>1:
            father_node = i/2 - 1
            if self.large_list[i-1] >= self.large_list[father_node]:
                break
            tmp = self.large_list[i-1]
            self.large_list[i-1] = self.large_list[father_node]
            self.large_list[father_node] = tmp
            i = father_node+1

    def findLarge(self, num):
        if not self.less_list or num >= self.less_list[0]:
            return num
        ret = self.less_list[0]
        self.less_list[0] = num
        i = 0
        while i < len(self.less_list) and (2*i+2) < len(self.less_list):
            if self.less_list[i] >= self.less_list[2*i+1] and self.less_list[i] >= self.less_list[2*i+2]:
                break
            elif self.less_list[2*i+1] > self.less_list[i] and self.less_list[2*i+1] > self.less_list[2*i+2]:
                tmp = self.less_list[i]
                self.less_list[i] = self.less_list[2*i+1]
                self.less_list[2*i+1] = tmp
                i = 2*i+1
            else:
                tmp = self.less_list[i]
                self.less_list[i] = self.less_list[2*i+2]
                self.less_list[2*i+2] = tmp
                i = 2*i+2
        if (2*i+2) == len(self.less_list):
            if self.less_list[2*i+1] > self.less_list[i]:
                tmp = self.less_list[i]
                self.less_list[i] = self.less_list[2*i+1]
                self.less_list[2*i+1] = tmp
        return ret

    def insertLess(self, num):
        self.less_list.append(num)
        i = len(self.less_list)
        while i>1:
            father_node = i/2 - 1
            if self.less_list[i-1] <= self.less_list[father_node]:
                break
            tmp = self.less_list[i-1]
            self.less_list[i-1] = self.less_list[father_node]
            self.less_list[father_node] = tmp
            i = father_node+1

    def findMedian(self):
        """
        :rtype: float
        """
        return self.median

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()

if __name__ == "__main__":
    obj = MedianFinder()
    obj.addNum(6)
    print(obj.findMedian())
    obj.addNum(10)
    print(obj.findMedian())
    obj.addNum(2)
    print(obj.findMedian())
    obj.addNum(6)
    print(obj.findMedian())
    obj.addNum(5)
    print(obj.findMedian())
    obj.addNum(0)
    print(obj.findMedian())
    obj.addNum(6)
    print(obj.findMedian())
    obj.addNum(3)
    print(obj.findMedian())
    obj.addNum(1)
    print(obj.findMedian())
    obj.addNum(0)
    print(obj.findMedian())
    obj.addNum(0)
    print(obj.findMedian())
