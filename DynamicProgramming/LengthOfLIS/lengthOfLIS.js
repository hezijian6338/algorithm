/**
根据该网站学习并且编写: https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485269&idx=1&sn=571a6366b0b592f103971ae3e119998b&chksm=9bd7f95daca0704be3c5c839cd96ab1a94efaefb48fa3101522a02fa19af9ef48170e03cd817&mpshare=1&scene=1&srcid=1019x3mKUXSJdEpVRvE8MIbe&sharer_sharetime=1603104666692&sharer_shareid=75f4c16dc57d6f06b28e6a1a014735c4&rd2werd=1#wechat_redirect
*/
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