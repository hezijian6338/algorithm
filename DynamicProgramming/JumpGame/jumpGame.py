class JumpGame(object):
    def canJump(self, nums) -> bool:
        n = len(nums)
        farthest = 0

        for i in range(n - 1):
            farthest = farthest if farthest > (i + nums[i]) else (i + nums[i])

            if (farthest <= i):
                return False
        
        return farthest >= (n - 1)

    def jump(self, nums) -> int:
        n = len(nums)
        farthest = 0
        end = 0
        jumps = 0

        for i in range(n - 1):
            farthest = farthest if farthest > (i + nums[i]) else (i + nums[i])

            if (i == end):
                jumps += 1
                end = farthest

        return jumps

jg = JumpGame()
nums = [2, 3, 1, 1, 4]
_nums = [3, 2, 1, 0, 4]
print(jg.canJump(nums))
print(jg.canJump(_nums))
print(jg.jump(nums))

