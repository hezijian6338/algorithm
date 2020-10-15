function minInsertions(str) {
    let dp = []
    for (let i = 0; i < str.length; i++) {
        let _dp = []
        for (let j = 0; j < str.length; j++) {
            _dp[j] = 0
        }
        dp.push(_dp)
    }
    // console.log(dp)

    let size = str.length

    for (let i = size - 2; i >= 0; i--) {
        for (let j = i + 1; j < size; j++) {
            if (str[i] == str[j]) {
                dp[i][j] = dp[i + 1][j - 1]
            } else {
                dp[i][j] = dp[i + 1][j] < dp[i][j - 1] ? (dp[i + 1][j] + 1) : (dp[i][j - 1] + 1)
            }
        }
    }

    for (let i = 0; i < str.length; i++) {
        console.log(`${dp[i]}`)
    }
    
    return dp[0][size - 1]
}

console.log(minInsertions('sbaddadabs'))