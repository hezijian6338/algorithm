# 自顶向下
def CoinChange(coins, amount):
    # 备忘录
    memo = dict()
    def dp(n):
        # 查备忘录，避免重复计算
        if n in memo: return memo[n]
        # base case
        if n == 0: return 0
        if n < 0: return -1
        res = float('INF')
        for coin in coins:
            subproblem = dp(n - coin)
            if subproblem == -1: continue
            res = min(res, 1 + subproblem)

        # 记入备忘录
        memo[n] = res if res != float('INF') else -1
        return memo[n]

    return dp(amount)

# 自底向上
def _CoinChange(coins, amount):
    memo = dict()

    memo[0] = 0

    for i in range(1, amount + 1):
        memo[i] = amount + 1

    for i in range(len(memo)):
        for coin in coins:
            if (i - coin) < 0:
                continue

            memo[i] = (memo[i - coin] + 1) if memo[i] > (memo[i - coin] + 1) else memo[i]

    return memo[amount] if memo[amount] != (amount + 1) else -1

print(_CoinChange([1,2,5], 10))

print(CoinChange([1,2,5], 10))
