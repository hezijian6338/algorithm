/**
根据该网站学习并且编写: https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/zui-da-zi-shu-zu
*/

class MaxSubArray {
  constructor() {

  }

  MaxSubArray(nums) {
    let size = nums.length
    if (size == 0) {
      return 0
    }

    let dp = []
    for (let i = 0; i < size; i++) {
      dp.push(0)
    }

    dp[0] = nums[0]

    for (let i = 1; i < size; i++) {
      if (nums[i] > (nums[i] + dp[i - 1])) {
        dp[i] = nums[i]
      } else {
        dp[i] = nums[i] + dp[i - 1]
      }
    }

    let max = 0
    for (let i = 0; i < size; i++) {
      max = max > dp[i] ? max : dp[i]
    }

    return max
  }
}

msa = new MaxSubArray()
nums = [-3, 4, -1, 2, -6, 1, 4]
console.log(msa.MaxSubArray(nums))