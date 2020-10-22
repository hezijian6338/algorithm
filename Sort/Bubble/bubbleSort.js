class BubbleSort {
  constructor() {

  }

  Sort(nums) {
    let swapped = true

    do {
      swapped = false
      for (let i = 1; i < nums.length; i++) {
        if (nums[i - 1] > nums[i]) {
          let tmp = nums[i - 1]
          nums[i - 1] = nums[i]
          nums[i] = tmp
          swapped = true
        }
      }  
    } while (swapped)

    return nums
  }

  Sort2(nums) {
    let size = nums.length

    for (let i = 0; i < size; i++) {
      for (let j = 1; j < size - i; j++) {
        if (nums[j - 1] > nums[j]) {
          let tmp = nums[j - 1]
          nums[j - 1] = nums[j]
          nums[j] = tmp 
        }
      }
    }
    return nums
  }

  Sort3(nums) {
    let swapped = true

    do {
      swapped = false
      for (let i = nums.length - 2; i >= 0; i--) {
        if (nums[i + 1] > nums[i]) {
          let tmp = nums[i + 1]
          nums[i + 1] = nums[i]
          nums[i] = tmp
          swapped = true
        }
      }
    } while (swapped)

    return nums
  }

  Sort4(nums) {
    let size = nums.length

    for (let i = 0; i < size; i++) {
      for (let j = size - 2; j >= 0 + i; j--) {
        if (nums[j + 1] > nums[j]) {
          let tmp = nums[j + 1]
          nums[j + 1] = nums[j]
          nums[j] = tmp
        }
      }
    }

    return nums
  }
}

bs = new BubbleSort()
let nums = [7, 6, 9, 8, 7, 6, 3, 7, 5, 5, 7, 8, 9, 7, 8]
console.log(bs.Sort(nums))
console.log(bs.Sort2(nums))
console.log(bs.Sort3(nums))
console.log(bs.Sort4(nums))