# -*- coding: utf-8 -*-

class Solution(object):
    def bagOfTokensScore(self, tokens, P):
        """
        :type tokens: List[int]
        :type P: int
        :rtype: int
        """
        tokens = sorted(tokens)
        points = 0
        i = 0
        while i < len(tokens) and P > 0:
            if P < tokens[i]:
                break
            P -= tokens[i]
            points += 1
            i += 1

        print points, P

        for 


if __name__ == "__main__":
    s = Solution()
    # print s.bagOfTokensScore([100], 50)
    # print s.bagOfTokensScore([100, 200], 150)
    print s.bagOfTokensScore([100, 200, 300, 400], 200)
    # print s.bagOfTokensScore([200, 100, 300, 400], 200)
