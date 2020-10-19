# 根据该网站学习并且编写: https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/bei-bao-zi-ji

class CanPartition:
    def canPartition(self, nums):
        _sum = 0
        for s in nums:
            _sum += s

        if _sum % 2 != 0:
            return False

        _sum = _sum / 2
        size = len(nums)

        dp = [[False]*(int(_sum) + 1) for n in range(size + 1)]

        for i in range(size + 1):
            dp[i][0] = True

        for i in range(1, size + 1):
            for s in range(1, int(_sum) + 1):
                if s - nums[i - 1] >= 0:
                    dp[i][s] = dp[i - 1][s - nums[i - 1]] or dp[i - 1][s]
                else:
                    dp[i][s] = dp[i - 1][s]

        return dp[size][int(_sum)]

cp = CanPartition()
print(cp.canPartition([1, 5, 11, 5]))