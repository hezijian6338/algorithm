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
}

s1 = 'abcde'
s2 = 'ace'
let lcs = new LongestCommonSubsequence(s1, s2)
const res = lcs.Recursion(s1.length - 1, s2.length - 1)
console.log(res)