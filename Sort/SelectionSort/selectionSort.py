class SelectionSort(object):
    def Sort(self, nums):
        for i in range(len(nums) - 1):
            mainJ = i
            for j in range(i + 1, len(nums)):
                if nums[mainJ] > nums[j]:
                    mainJ = j
            
            if i != mainJ:
                tmp = nums[mainJ]
                nums[mainJ] = nums[i]
                nums[i] = tmp
        return nums

    def Sort2(self, nums):
        for i in range(len(nums) - 1, -1, -1):
            mainJ = i
            for j in range(i - 1, -1, -1):
                if nums[j] < nums[mainJ]:
                    mainJ = j

            if i != mainJ:
                tmp = nums[mainJ]
                nums[mainJ] = nums[i]
                nums[i] = tmp

        return nums
ss = SelectionSort()
nums = [3, 5, 8, 5, 4, 3, 8, 8, 2, 4, 3, 3, 7, 4, 5]
print(ss.Sort(nums))
print(ss.Sort2(nums))
              