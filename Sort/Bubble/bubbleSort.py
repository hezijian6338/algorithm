class BubbleSort(object):
    def Sort(self, nums):
        swapped = True
        while (swapped):
            swapped = False
            for i in range(1, len(nums) - 1):
                if nums[i] < nums[i - 1]:
                    tmp = nums[i - 1]
                    nums[i - 1] = nums[i]
                    nums[i] = tmp
                    swapped = True
        return nums

    def Sort2(self, nums):
        for i in range(len(nums)):
            for j in range(1 + i, len(nums) - 1):
                if nums[j] < nums[j - 1]:
                    tmp = nums[j - 1]
                    nums[j - 1] = nums[j]
                    nums[j] = tmp

        return nums


    def Sort3(self, nums):
        swapped = True
        while swapped:
            swapped = False
            for i in range(len(nums) - 2, -1, -1):
                if nums[i + 1] > nums[i]:
                    tmp = nums[i + 1]
                    nums[i + 1] = nums[i]
                    nums[i] = tmp
                    swapped = True

        return nums

    def Sort4(self, nums):
        for i in range(len(nums) - 1):
            for j in range(len(nums) - 2, -1 + i, -1):
                if nums[j + 1] > nums[j]:
                    tmp = nums[j + 1]
                    nums[j + 1] = nums[j]
                    nums[j] = tmp
        
        return nums

bs = BubbleSort()
nums = [7, 6, 9, 8, 7, 6, 3, 7, 5, 5, 7, 8, 9, 7, 8]
print(bs.Sort(nums))
print(bs.Sort2(nums))
print(bs.Sort3(nums))
print(bs.Sort4(nums))