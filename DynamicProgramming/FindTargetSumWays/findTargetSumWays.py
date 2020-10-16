# 根据该网站学习并且编写: https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/targetsum

class FindTargetSumWays(object):
    def __init__(self):
        self.result = 0
        self.memo = dict()
        print('init...')

    # 回溯法
    def backtrack(self, nums, i, rest):
        if i == len(nums):
            if rest == 0:
                self.result += 1
            return

        self.backtrack(nums, i + 1, rest + nums[i])
        self.backtrack(nums, i + 1, rest - nums[i])

    def dp(self, nums, i, rest):
        if i == len(nums):
            if rest == 0:
                return 1
            return 0
        
        if (i, rest) in self.memo:
            return self.memo[(i, rest)]

        res = self.dp(nums, i + 1, rest - nums[i]) + self.dp(nums, i + 1, rest + nums[i])
        self.memo[(i, rest)] = res
        return res

ftsw = FindTargetSumWays()
ftsw.backtrack([1, 1, 1, 1, 1], 0, 3)
print(ftsw.result)
print(ftsw.dp([1, 1, 1, 1, 1], 0, 3))