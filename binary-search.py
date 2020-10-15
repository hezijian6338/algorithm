class BinarySearch(object):
    def __init__(self, nums, target):
        self.__nums = nums
        self.__target = target

    def base(self):
        nums = self.__nums
        left = 0
        right = len(nums) - 1
        target = self.__target

        while left <= right:
            mid = left + (right - left) % 2

            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
        
        return -1

    def leftBound(self):
        nums = self.__nums
        left = 0
        right = len(nums) - 1
        target = self.__target

        while left <= right:
            mid = left + (right - left) % 2

            if nums[mid] > target:
                right = mid - 1
            elif nums[mid] < target:
                left = mid + 1
            elif nums[mid] == target:
                right = mid - 1
        # 左边界判断左, 返回左 (因为右边界跳出循环时候, 假设 target在队列, 会是 index - 1了) 
        if left > len(nums) or nums[left] != target:
           return -1
        return left

        # if right + 1 < 0 or nums[right + 1] != target:
        #     return -1
        # return right + 1

    def rightBound(self):
        nums = self.__nums
        left = 0
        right = len(nums) - 1
        target = self.__target

        while left <= right:
            mid = left + (right - left) % 2

            if nums[mid] > target:
                right = mid - 1
            elif nums[mid] < target:
                left = mid + 1
            elif nums[mid] == target:
                left = mid + 1

        # 右边界判断右, 返回右 (因为左边界跳出循环时候, 假设 target在队列, 会是 index + 1了)  
        if right < 0 or nums[right] != target:       
            return -1
        return right

        # if left - 1 > len(nums) or nums[left - 1] != target:
        #    return -1
        # return left - 1


nums = [1, 2, 2, 4, 4, 4, 6]
target = 0
bs = BinarySearch(nums, target)
print('数列: %s --- 目标: %s' % (nums, target))
print('基础二分查找:  ' , bs.base())
print('左边界二分查找:  ', bs.leftBound())
print('右边界二分查找:  ', bs.rightBound())

target = 4
bs1 = BinarySearch(nums, target)
print('数列: %s --- 目标: %s' % (nums, target))
print('基础二分查找:  ' , bs1.base())
print('左边界二分查找:  ', bs1.leftBound())
print('右边界二分查找:  ', bs1.rightBound())

target = 2
bs2 = BinarySearch(nums, target)
print('数列: %s --- 目标: %s' % (nums, target))
print('基础二分查找:  ' , bs2.base())
print('左边界二分查找:  ', bs2.leftBound())
print('右边界二分查找:  ', bs2.rightBound())
