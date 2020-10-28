class LengthOfLIS {
  constructor() {
    this.max = 0
    this.memo = new Map()
  }

  backtrack(nums, i, tmp) {
    if (i == 0) {
      if (this.max < tmp) {
        this.max = tmp
      }
      return
    }

    for (let j = i - 1; j >= 0; j--) {
      if (nums[i] > nums[j]) {
        tmp += 1
        this.backtrack(nums, j, tmp)
        tmp -= 1
      } else {
        this.backtrack(nums, j, 1)
      }
    }
  }

  dp(nums, i, tmp) {
    if (this.memo.has(i)) {
      return this.memo.get(i)
    }

    if (i == 0) {
      if (this.max < tmp) {
        this.max = tmp
      }
      this.memo.set(i, this.max)
      return this.max
    }

    for (let j = i - 1; j >= 0; j--) {
      if (nums[i] > nums[j]) {
        let res = this.dp(nums, j, tmp) + 1
        this.memo.set(i, res)
        return res
      }
    }
  }

  LengthOfLIS(nums) {
    let dp = []
    for (let i = 0; i < nums.length; i++) {
      dp.push(1)
    }

    for (let i = 0; i < nums.length; i++) {
      for (let j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = dp[i] > (dp[j] + 1) ? dp[i] : (dp[j] + 1)
        }
      }
    }

    let max = 0
    for (let i = 0; i < dp.length; i++) {
      if (dp[i] > max) {
        max = dp[i]
      }
    }

    return max
  }

}

let lis = new LengthOfLIS()
let nums = [2, 4, 6, 4, 5, 7]
lis.backtrack(nums, nums.length - 1, 1)
console.log(lis.max)
lis.max = 0
console.log(lis.dp(nums, nums.length - 1, 1))
console.log(lis.LengthOfLIS(nums))