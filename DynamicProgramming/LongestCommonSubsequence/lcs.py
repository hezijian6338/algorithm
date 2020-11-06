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

    def dp(self):
        dp = [[0] * (len(self.s2) + 1) for _ in range(len(self.s1) + 1)]

        for i in range(len(self.s1) + 1):
            dp[i][0] = 0

        for i in range(len(self.s2) + 1):
            dp[0][i] = 0

        for i in range(1, len(self.s1) + 1):
            for j in range(1, len(self.s2) + 1):
                if self.s1[i - 1] == self.s2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    dp[i][j] = dp[i - 1][j] if dp[i - 1][j] > dp[i][j - 1] else dp[i][j - 1]

        return dp[len(self.s1)][len(self.s2)]

s1 = 'abcde'
s2 = 'ace'
lcs = LongestCommonSubsequence(s1, s2)
res = lcs.Recursion(len(s1) - 1, len(s2) - 1)
print(res)
print(lcs.dp())