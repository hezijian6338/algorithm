class LongestCommonSubsequence {
  constructor(s1, s2) {
    this.s1 = s1
    this.s2 = s2
  }

  Recursion(i, j) {
    if (i == -1 || j == -1) {
      return 0
    }

    if (this.s1.charAt(i) == this.s2.charAt(j)) {
      return this.Recursion(i - 1, j - 1) + 1
    } else {
      return this.Recursion(i - 1, j) > this.Recursion(i, j - 1) ? this.Recursion(i - 1, j) : this.Recursion(i, j - 1)
    }
  }

  dp() {
    let dp = []

    for (let i = 0; i < this.s1.length + 1; i++) {
      let tmp = []
      for (let j = 0; j < this.s2.length + 1; j++) {
        tmp.push(0)
      }
      dp.push(tmp)
    }

    for (let i = 1; i < this.s1.length + 1; i++) {
      for (let j = 1; j < this.s2.length + 1; j++) {
        if (this.s1.charAt(i - 1) == this.s2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1
        } else {
          dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1]
        }
      }
    }
    return dp[this.s1.length][this.s2.length]
  }
}

s1 = 'abcde'
s2 = 'ace'
let lcs = new LongestCommonSubsequence(s1, s2)
const res = lcs.Recursion(s1.length - 1, s2.length - 1)
console.log(res)
console.log(lcs.dp())