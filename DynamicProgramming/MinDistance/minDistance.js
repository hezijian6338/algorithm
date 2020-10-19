class MinDistance {
  constructor(s1, s2) {
    this.s1 = s1
    this.s2 = s2
    this.tmp = 0
    this.min = 999
    this.memo = new Map()
  }

  backtrack(i, j) {
    if (i == -1) {
      let _tmp = this.tmp + j + 1
      if (_tmp < this.min)
        this.min = _tmp
      return
    }

    if (j == -1) {
      let _tmp = this.tmp + i + 1
      if (_tmp < this.min)
        this.min = _tmp
      return
    }

    if (this.s1.charAt(i) == this.s2.charAt(j)) {
      this.backtrack(i - 1, j - 1)
    } else {
      this.tmp += 1
      this.backtrack(i, j - 1)
      this.tmp -= 1

      this.tmp += 1
      this.backtrack(i - 1, j)
      this.tmp -= 1

      this.tmp += 1
      this.backtrack(i - 1, j - 1)
      this.tmp -= 1
    }
  }

  recursion(i, j) {
    if (i == -1) {
      return j + 1
    }
    if (j == -1) {
      return i + 1
    }

    if (this.s1.charAt(i) == this.s2.charAt(j)) {
      return this.recursion(i - 1, j - 1)
    }

    let insert = this.recursion(i, j - 1) + 1
    let _delete = this.recursion(i - 1, j) + 1
    let replace = this.recursion(i - 1, j - 1) + 1

    return (insert < _delete ? insert : _delete) < replace ? (insert < _delete ? insert : _delete) : replace
    
  }

  dp(i, j) {
    let key = `${i},${j}`
    if (this.memo.has(key)) {
      return this.memo.get(key)
    }

    if (i === -1) {
      this.memo.set(key, j + 1)
      return j + 1
    }

    if (j === -1) {
      this.memo.set(key, i + 1)
      return i + 1
    }

    if (this.s1.charAt(i) === this.s2.charAt(j)) {
      return this.dp(i - 1, j - 1)
    }

    let insert = this.dp(i, j - 1) + 1
    let _delete = this.dp(i - 1, j) + 1
    let replace = this.dp(i - 1, j - 1) + 1

    return (insert < _delete ? insert : _delete) < replace ? (insert < _delete ? insert : _delete) : replace
  }

  MinDistance() {
    let _s1 = this.s1.length
    let _s2 = this.s2.length

    let _dp = []

    for (let i = 0; i <= _s1; i++) {
      let tmp = []
      for (let j = 0; j <= _s2; j++) {
        if (i == 0) {
          tmp.push(j)
        } 
        else if (j == 0) {
          tmp.push(i)
        } else {
          tmp.push(0)
        }
      }
      _dp.push(tmp)
    }

    for (let i = 1; i <= _s1; i++) {
      for (let j = 1; j <= _s2; j++) {
        if (this.s1.charAt(i - 1) == this.s2.charAt(j - 1)) {
          _dp[i][j] = _dp[i - 1][j - 1]
        } else {
          let insert = _dp[i][j - 1] + 1
          let _delete = _dp[i - 1][j] + 1
          let replace = _dp[i - 1][j - 1] + 1

          _dp[i][j] = (insert < _delete ? insert : _delete) < replace ? (insert < _delete ? insert : _delete) : replace
        }
      }
    }

    return _dp[_s1][_s2]
  }

}

let s1 = 'horse'
let s2 = 'ros'
let md = new MinDistance(s1, s2)
md.backtrack(s1.length - 1, s2.length - 1)
console.log(md.min)
console.log(md.recursion(s1.length - 1, s2.length - 1))
console.log(md.dp(s1.length - 1, s2.length - 1))
console.log(md.MinDistance())