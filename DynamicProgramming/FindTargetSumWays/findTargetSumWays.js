// 根据该网站学习并且编写: https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/targetsum

class FindTargetSumWays {
    constructor() {
        this.result = 0
        this.memo = new Map()
    }

    // 回溯法
    backtrack(nums, i, rest) {
        if (i == nums.length) {
            if (rest == 0) {
                this.result++
            }
            return;
        }

        this.backtrack(nums, i + 1, rest + nums[i])
        this.backtrack(nums, i + 1, rest - nums[i])
    }

    // 备忘录法
    dp(nums, i, rest) {
        if (i == nums.length) {
            if (rest == 0) {
                return 1
            }
            return 0
        }

        let key = i + "," + rest
        if (this.memo.has(key)) {
            return this.memo.get(key)
        }

        let res = this.dp(nums, i + 1, rest + nums[i]) + this.dp(nums, i + 1, rest - nums[i])
        this.memo.set(key, res)
        return res
    }
}

let ftsw = new FindTargetSumWays()
let nums = [1, 1, 1, 1, 1]
ftsw.backtrack(nums, 0, 3)
console.log(ftsw.result)
console.log(ftsw.dp(nums, 0, 3))