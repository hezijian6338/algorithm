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
                self.memo[i] = self.max
                return self.max
            return tmp

        for j in range(i - 1, -1, -1):
            if nums[i] > nums[j]:
                res = self.dp(nums, j, tmp) + 1
                self.memo[i] = res
                return res
            else:
                res = self.dp(nums, j, 1)
                self.memo[i] = res
                return res

lis = LengthOfLIS()
nums = [2, 4, 6, 4, 5, 7]
lis.backtrack(nums, len(nums) - 1, 1)
print(lis.max)
lis.max = 0
print(lis.dp(nums, len(nums) - 1, 1))
print(lis.memo)