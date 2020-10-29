# 根据该网站学习并且编写: https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/zui-da-zi-shu-zu

class MaxSubArray(object):
    def MaxSubArray(self, nums):
        dp = [0 for i in range(len(nums))]
        size = len(nums)

        if size == 0:
            return
        
        dp[0] = nums[0]

        for i in range(1, len(nums)):
            dp[i] = nums[i] if nums[i] > (nums[i] + dp[i - 1]) else (nums[i] + dp[i - 1])

        max = 0
        for i in range(len(nums)):
            if max < dp[i]:
                max = dp[i]
        
        return max

msa = MaxSubArray()
nums = [-3, 4, -1, 2, -6, 1, 4]
print(msa.MaxSubArray(nums))
