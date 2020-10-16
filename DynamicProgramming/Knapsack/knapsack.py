# 根据该网站学习并且编写: https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485064&idx=1&sn=550705eb67f5e71487c8b218382919d6&chksm=9bd7f880aca071962a5a17d0f85d979d6f0c5a5ce32c84b8fee88e36d451f9ccb3bb47b88f78&mpshare=1&scene=1&srcid=1015MFuGMgLE69gGGB7kpPSN&sharer_sharetime=1602723704054&sharer_shareid=75f4c16dc57d6f06b28e6a1a014735c4&rd2werd=1#wechat_redirect

class Knapsack:
    def __init__(self):
        self.result = 0
        self.max = 0
        self.memo = dict()
        self._dp = []

    # 回溯法
    def backtrack(self, N, W, wt, val, i):
        if N <= 0 or W <= 0:
            if self.result > self.max:
                self.max = self.result
            return

        if W - wt[i] >= 0:
            self.result += val[i]
            self.backtrack(N - 1, W - wt[i], wt, val, i + 1)
            self.result -= val[i]

        self.result += 0
        self.backtrack(N - 1, W, wt, val, i + 1)
        self.result -= 0

    # 备忘录法
    def dp(self, N, W, wt, val, i):
        if N <= 0 or W <= 0:
            return 0

        if (W, i) in self.memo:
            return self.memo[(W, i)]

        if W - wt[i] >= 0:
            add = self.dp(N - 1, W - wt[i], wt, val, i + 1) + val[i]
        else:
            add = self.dp(N - 1, W, wt, val, i + 1)

        minus = self.dp(N - 1, W, wt, val, i + 1)
        self.memo[(W, i)] = add if add > minus else minus
        return add if add > minus else minus

    # dp Table
    def knapsack(self, N, W, wt, val):
        self._dp = [[-1]*(W + 1) for i in range(N + 1)]
        

        # basecase: 没有空间了
        for i in range(N + 1):
            self._dp[i][0] = 0

        # basecase: 没有物品了
        for w in range(W + 1):
            self._dp[0][w] = 0

        for i in range(1, N + 1, 1):
            for w in range(1, W + 1, 1):
                if w - wt[i - 1] >= 0:
                    self._dp[i][w] = self._dp[i - 1][w] if (self._dp[i - 1][w]) > (self._dp[i - 1][w - wt[i - 1]] + val[i - 1]) else (self._dp[i - 1][w - wt[i - 1]] + val[i - 1])
                else:
                    self._dp[i][w] = self._dp[i - 1][w]
                    
        return self._dp[N][W]

ks = Knapsack()
ks.backtrack(3, 4, [2, 1, 3], [4, 2, 3], 0)
print(ks.max)
print(ks.dp(3, 4, [2, 1, 3], [4, 2, 3], 0))
res = ks.knapsack(3, 4, [2, 1, 3], [4, 2, 3])
print(res)
for i in range(3 + 1):
    print(ks._dp[i])
