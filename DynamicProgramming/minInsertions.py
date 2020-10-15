def minInsertions(str):
    dp = [[0]*len(str) for i in range(len(str))]

    size = len(str)

    # for (n - 2; n >= 0; n--)
    for i in range(size - 2, -1, -1):
        # print(i)
        for j in range(i + 1, size):
            # print(j)
            if str[i] == str[j]:
                dp[i][j] = dp[i+1][j-1]
            
            if str[i] != str[j]:
                dp[i][j] = (dp[i + 1][j] + 1) if dp[i + 1][j] < dp[i][j - 1] else (dp[i][j - 1] + 1)

    for n in range(len(dp)):
        print(dp[n])
    return dp[0][size - 1]

print(minInsertions('sbaddadabs'))
