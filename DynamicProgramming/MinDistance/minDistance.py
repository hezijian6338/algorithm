# 根据该网站学习并且编写: https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/bian-ji-ju-li

class MinDistance(object):
    def __init__(self, s1, s2):
        self.s1 = s1
        self.s2 = s2
        self.min = 999
        self.tmp = 0
        self.memo = dict()

    # 回溯法
    def backtrack(self, i, j):
        if i == -1:
            _tmp = self.tmp + j + 1
            if _tmp < self.min:
                self.min = _tmp
            return

        if j == -1:
            _tmp = self.tmp + i + 1
            if _tmp < self.min:
                self.min = _tmp
            return

        if self.s1[i] == self.s2[j]:
            self.backtrack(i - 1, j - 1)
        else:
            self.tmp += 1
            self.backtrack(i, j - 1)
            self.tmp -= 1

            self.tmp += 1
            self.backtrack(i - 1, j)
            self.tmp -= 1

            self.tmp += 1
            self.backtrack(i - 1, j - 1)
            self.tmp -= 1

    # 递归
    def recursion(self, i, j):
      if i == -1:
          return j + 1
      
      if j == -1:
          return i + 1

      if self.s1[i] == self.s2[j]:
          return self.recursion(i - 1, j - 1)
      else:
        insert = self.recursion(i, j - 1) + 1
        delete = self.recursion(i - 1, j) + 1
        replace = self.recursion(i - 1, j - 1) + 1

        return (insert if insert < delete else delete) if (insert if insert < delete else delete) < replace else replace

    # 备忘录
    def dp(self, i, j):
        if (i, j) in self.memo:
            return self.memo[(i, j)]
        
        if i == -1:
            self.memo[(i, j)] = j + 1
            return j + 1

        if j == -1:
            self.memo[(i, j)] = i + 1
            return i + 1

        if self.s1[i] == self.s2[j]:
            return self.dp(i - 1, j - 1)
        else:
            insert = self.dp(i, j - 1) + 1
            delete = self.dp(i - 1, j) + 1
            replace = self.dp(i - 1, j - 1) + 1

            return (insert if insert < delete else delete) if (insert if insert < delete else delete) < replace else replace

    # dp Table
    def MinDistance(self):
        _s1 = len(self.s1)
        _s2 = len(self.s2)

        dp = [[0]*(_s2 + 1) for i in range(_s1 + 1)]

        for i in range(_s1 + 1):
            dp[i][0] = i

        for i in range(_s2 + 1):
            dp[0][i] = i

        for i in range(1, (_s1 + 1)):
            for j in range(1, (_s2 + 1)):
                if self.s1[i - 1] == self.s2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    insert = dp[i][j - 1] + 1
                    delete = dp[i - 1][j] + 1
                    replace = dp[i - 1][j - 1] + 1

                    dp[i][j] = (insert if insert < delete else delete) if (insert if insert < delete else delete) < replace else replace
        
        return dp[_s1][_s2]

s1 = 'horse'
s2 = 'ros'
md = MinDistance(s1, s2)
md.backtrack(len(s1) - 1, len(s2) - 1)
print(md.min)
print(md.recursion(len(s1) - 1, len(s2) - 1))
print(md.dp(len(s1) - 1, len(s2) - 1))
print(md.MinDistance())
