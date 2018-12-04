# -*- coding: utf-8 -*-

class Solution(object):
    def surfaceArea(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        total = 0
        n = len(grid)
        for i, row in enumerate(grid):
            for j, element in enumerate(row):
                total += (element*4+2 if element else 0)
                total -= 2*min(grid[i+1][j] if i+1<n else 0, element)
                total -= 2*min(grid[i][j+1] if j+1<n else 0, element)
        return total

if __name__ == "__main__":
    s = Solution()
    print s.surfaceArea([[2]])
    print s.surfaceArea([[1,2],[3,4]])
    print s.surfaceArea([[1,0],[0,2]])
    print s.surfaceArea([[1,1,1],[1,0,1],[1,1,1]])
    print s.surfaceArea([[2,2,2],[2,1,2],[2,2,2]])
