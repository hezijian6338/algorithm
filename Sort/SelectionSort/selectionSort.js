class SelectionSort {
  constructor() {

  }

  Sort(nums) {
    for (let i = 0; i < nums.length - 1; i++) {
      let mainJ = i
      for (let j = i + 1; j < nums.length; j++) {
        if (nums[j] < nums[mainJ]) {
          mainJ = j
        }
      }

      if (i != mainJ) {
        const tmp = nums[mainJ]
        nums[mainJ] = nums[i]
        nums[i] = tmp
      }
    }

    return nums
  }

  Sort2(nums) {
    for (let i = nums.length - 1; i >= 0; i--) {
      let mainJ = i
      for (let j = i - 1; j >= 0; j--) {
        if (nums[j] < nums[mainJ]) {
          mainJ = j
        }
      }

      if (i != mainJ) {
        const tmp = nums[mainJ]
        nums[mainJ] = nums[i]
        nums[i] = tmp
      }
    }

    return nums
  }
  
}

let ss = new SelectionSort()
let nums = [3, 5, 8, 5, 4, 3, 8, 8, 2, 4, 3, 3, 7, 4, 5]

console.log(ss.Sort(nums))
console.log(ss.Sort2(nums))