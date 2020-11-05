class LongestCommonSubsequence(object):
    def __init__(self, s1, s2):
        self.s1 = s1
        self.s2 = s2

    def Recursion(self, i, j):
        if i == -1 or j == -1:
            return 0
        
        if self.s1[i] == self.s2[j]:
            return self.Recursion(i - 1, j - 1) + 1
        else:
            return self.Recursion(i - 1, j) if self.Recursion(i - 1, j) > self.Recursion(i, j - 1) else self.Recursion(i, j - 1)

s1 = 'abcde'
s2 = 'ace'
lcs = LongestCommonSubsequence(s1, s2)
res = lcs.Recursion(len(s1) - 1, len(s2) - 1)
print(res)