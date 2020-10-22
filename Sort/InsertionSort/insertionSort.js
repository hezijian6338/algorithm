class InsertionSort {
  constructor() {

  }

  Sort(nums) {
    for (let i = 1; i < nums.length; i++) {
      let key = nums[i]

      let j = 0
      for (j = i - 1; (j >= 0) && (nums[j] > key); j--) {
        nums[j + 1] = nums[j]
      }

      nums[j + 1] = key
    }

    return nums
  }

  Sort2(nums) {
    for (let i = 1; i < nums.length; i++) {
      let key = nums[i]

      let j = 0
      for (j = i - 1; (j >= 0) && (nums[j] < key); j--) {
        nums[j + 1] = nums[j]
      }

      nums[j + 1] = key
    }

    return nums
  }

}

let is = new InsertionSort()
let nums = [3, 2, 3, 6, 2, 4, 3, 4, 9, 4, 4, 5, 3, 1, 9]
console.log(is.Sort(nums))
console.log(is.Sort2(nums))