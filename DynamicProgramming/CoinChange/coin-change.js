// base case: 0 --> 0; -1 --> -1
// 状态 dp[n]
// 选择 coins

// 自底向上
function CoinsChange(coins, target) {
    let memo = []

    // 初始化所有的值 (最小面额为 1, 所以最大的金额数量是 target + 1 (避免等于情况, 所以 + 1, 约等于正无穷), 数组的大小也是 target + 1 (便于取值 target))
    for (let i = 0; i <= target; i++) {
        memo[i] = target + 1
    }

    memo[0] = 0

    for (let i = 0; i < memo.length; i++) {
        for (let coin of coins) {

            if (i - coin < 0) {
                continue
            }

            memo[i] = memo[i] < (1 + memo[i - coin]) ? memo[i] : (1 + memo[i - coin])
            console.log(`凑金额 ${i}, 需要: ${memo[i]} 枚硬币`)
        }
    }
    return memo[target] == (target + 1) ? -1 : memo[target]
}

class _CoinsChange {

    coinschange(coins, target) {
        this.coins = coins
        return this.dp(target)
    }

    dp(target) {
        if (target == 0) {
            return 0
        }

        if (target < 0) {
            return -1
        }

        let res = target + 1

        for (let coin of this.coins) {
            let subproblem = this.dp(target - coin)

            if (subproblem == -1) {
                continue
            }

            res = res < (subproblem + 1) ? res : (subproblem + 1)
        }
        console.log(`凑金额 ${target}, 需要: ${res} 枚硬币`)
        return res == (target + 1) ? -1 : res
    }
}

class __CoinsChange {

    constructor() {
        this.memo = []
    }

    coinschange(coins, target) {
        this.coins = coins
        return this.dp(target)
    }

    dp(target) {
        if (target == 0) {
            this.memo[0] = 0
            return 0
        }

        if (target < 0) {
            return -1
        }

        if (this.memo[target] != undefined) {
            return this.memo[target]
        }

        let res = target + 1

        for (let coin of this.coins) {
            let subproblem = this.dp(target - coin)

            if (subproblem < 0) {
                continue
            }

            res = res < (subproblem + 1) ? res : (subproblem + 1) 
        }
        res = res == (target + 1) ? -1 : res
        this.memo[target] = res
        console.log(`凑金额 ${target}, 需要: ${res} 枚硬币`)
        return res
    }
}

coins = [1, 2, 5, 9]
target = 11

let __cc = new __CoinsChange()

console.log(__cc.coinschange(coins, target))

let _cc = new _CoinsChange()

console.log(_cc.coinschange(coins, target))

let cc = CoinsChange(coins, target)

console.log(cc)

