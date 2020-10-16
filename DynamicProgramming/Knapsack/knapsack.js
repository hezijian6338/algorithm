/**
根据该网站学习并且编写: https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485064&idx=1&sn=550705eb67f5e71487c8b218382919d6&chksm=9bd7f880aca071962a5a17d0f85d979d6f0c5a5ce32c84b8fee88e36d451f9ccb3bb47b88f78&mpshare=1&scene=1&srcid=1015MFuGMgLE69gGGB7kpPSN&sharer_sharetime=1602723704054&sharer_shareid=75f4c16dc57d6f06b28e6a1a014735c4&rd2werd=1#wechat_redirect
*/

class Knapsack {
    constructor() {
        this.result = 0
        this.max = 0
        this.memo = new Map()
        this._dp = []
    }

    // 回溯法
    backtrack(N, W, wt, val, i) {
        if (W <= 0 || N <= 0) {
            if (this.result > this.max) {
                this.max = this.result
            }
            return
        }

        if (W - wt[i] >= 0) {
            this.result += val[i]
            this.backtrack(N - 1, W - wt[i], wt, val, i + 1)
            this.result -= val[i]
        }

        this.result += 0
        this.backtrack(N - 1, W, wt, val, i + 1)
        this.result -= 0
    }

    // 备忘录法
    dp(N, W, wt, val, i) {
        if (N <= 0 || W <= 0) {
            return 0
        }

        let key = W + "," + i
        if (this.memo.has(key)) {
            return this.memo.get(key)
        }

        let res = 0

        if (W - wt[i] >= 0) {
            res = (this.dp(N - 1, W - wt[i], wt, val, i + 1) + val[i]) > (this.dp(N - 1, W, wt, val, i + 1)) ? (this.dp(N - 1, W - wt[i], wt, val, i + 1) + val[i]) : this.dp(N - 1, W, wt, val, i + 1)
        } else {
            res = this.dp(N - 1, W, wt, val, i + 1)
        }

        this.memo.set(key, res)
        return res
    }

    // dp Table法
    knapsack(N, W, wt, val) {
        for (let i = 0; i <= N; i++) {
            let array = []
            for (let j = 0; j <= W; j++) {
                array.push(-1)
            }
            this._dp.push(array)
        }

        // basecase: 物品为空
        for (let i = 0; i <= N; i++) {
            this._dp[i][0] = 0
        }

        // basecase: 背包满了
        for (let w = 0; w <= W; w++) {
            this._dp[0][w] = 0
        }

        for (let i = 1; i <= N; i++) {
            for (let w = 1; w <= W; w++) {
                if (w - wt[i - 1] >= 0) {
                    this._dp[i][w] = (this._dp[i - 1][w - wt[i - 1]] + val[i - 1]) > this._dp[i - 1][w] ? (this._dp[i - 1][w - wt[i - 1]] + val[i - 1]) : this._dp[i - 1][w]
                } else {
                    this._dp[i][w] = this._dp[i - 1][w]
                }
            }
        }
        return this._dp[N][W]
    }
}

ks = new Knapsack()
ks.backtrack(3, 4, [2, 1, 3], [4, 2, 3], 0)
console.log(ks.max)
console.log(ks.dp(3, 4, [2, 1, 3], [4, 2, 3], 0))
console.log(ks.knapsack(3, 4, [2, 1, 3], [4, 2, 3]))