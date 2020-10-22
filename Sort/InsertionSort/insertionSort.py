class InsertionSort(object):
    def Sort(self, nums):
        for i in range(1, len(nums)):
            key = nums[i]

            j = i - 1
            while nums[j] > key and j >= 0:
              nums[j + 1] = nums[j]
              j -= 1
            
            nums[j + 1] = key

        return nums

    def Sort2(self, nums):
        for i in range(1, len(nums)):
            key = nums[i]

            j = i - 1
            while j >= 0 and nums[j] < key:
                nums[j + 1] = nums[j]
                j -= 1
            
            nums[j + 1] = key

        return nums

IS = InsertionSort()
nums = [3, 2, 3, 6, 2, 4, 3, 4, 9, 4, 4, 5, 3, 1, 9]
print(IS.Sort(nums))
print(IS.Sort2(nums))