class CoinChange2(object):

    def __init__(self):
        self.track = []
        self.path = set()
        self.res = 0

    def backtrack(self, coins, rest):
        if rest == 0:
            self.track.sort()
            if tuple(self.track) not in self.path:
                self.res += 1
                self.path.add(tuple(self.track))
            return

        for i in range(len(coins)):
            if rest - coins[i] >= 0:
                rest = rest - coins[i]
                self.track.append(coins[i])
                self.backtrack(coins, rest)
                rest = rest + coins[i]
                self.track.pop(-1)
            else:
                continue

    def CoinChange2(self, coins, target):
        dp = [[0]*(target + 1) for i in range(len(coins) + 1)]
        for i in range(target + 1):
            dp[0][i] = 0
        for i in range(len(coins) + 1):
            dp[i][0] = 1

        for i in range(1, len(coins) + 1):
            for j in range(1, target + 1):
                if j - coins[i - 1] >= 0:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
                else:
                    dp[i][j] = dp[i - 1][j]
        
        return dp[len(coins)][target]

cc2 = CoinChange2()
coins = [1, 2, 5]
target = 5
print(cc2.CoinChange2(coins, target))
cc2.backtrack(coins, target)
print(cc2.res)



