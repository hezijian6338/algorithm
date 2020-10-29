# 根据该网站学习并且编写: https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485269&idx=1&sn=571a6366b0b592f103971ae3e119998b&chksm=9bd7f95daca0704be3c5c839cd96ab1a94efaefb48fa3101522a02fa19af9ef48170e03cd817&mpshare=1&scene=1&srcid=1019x3mKUXSJdEpVRvE8MIbe&sharer_sharetime=1603104666692&sharer_shareid=75f4c16dc57d6f06b28e6a1a014735c4&rd2werd=1#wechat_redirect

class LengthOfLIS(object):
    def __init__(self):
        self.max = 0
        self.memo = dict()
    
    def backtrack(self, nums, i, tmp):
        if i == 0:
            if self.max < tmp:
                self.max = tmp
            return

        for j in range(i - 1, -1, -1):
            if nums[i] > nums[j]:
                tmp += 1
                self.backtrack(nums, j, tmp)
                tmp -= 1
            else:
                self.backtrack(nums, j, 1)

    def dp(self, nums, i, tmp):
        if i in self.memo:
            return self.memo[i]

        if i == 0:
            if self.max < tmp:
                self.max = tmp
            self.memo[i] = self.max
            return self.max

        for j in range(i - 1, -1, -1):
            if nums[i] > nums[j]:
                res = self.dp(nums, j, tmp) + 1
                self.memo[i] = res
                return res

    def LengthOfLIS(self, nums):
        dp = [1 for n in range(len(nums))]

        for i in range(len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = dp[i] if dp[i] > dp[j] + 1 else dp[j] + 1
        
        print(dp)
        
        max = 0
        for i in range(len(dp)):
            if dp[i] > max:
                max = dp[i]
        return max



lis = LengthOfLIS()
nums = [2, 4, 6, 4, 5, 7]
lis.backtrack(nums, len(nums) - 1, 1)
print(lis.max)
lis.max = 0
print(lis.dp(nums, len(nums) - 1, 1))
print(lis.memo)
print(lis.LengthOfLIS(nums))