class JumpGame {
  constructor() {

  }

  canJump(nums) {
    let n = nums.length
    let farthest = 0

    for (let i = 0; i < n - 1; i++) {
      if (farthest < (nums[i] + i)) {
        farthest = (nums[i] + i)
      }

      if (farthest <= i) {
        return false
      }
    }

    return farthest >= (n - 1)
  }

  jump(nums) {
    let n = nums.length
    let farthest = 0
    let end = 0
    let jumps = 0

    for (let i = 0; i < n - 1; i++) {
      if (farthest < (nums[i] + i)) {
        farthest = (nums[i] + i)
      }

      if (i == end) {
        jumps++
        end = farthest
      }
    }

    return jumps
  }
}

let jg = new JumpGame()
const nums = [2, 3, 1, 1, 4]
const _nums = [3, 2, 1, 0, 4]
console.log(jg.canJump(nums))
console.log(jg.canJump(_nums))
console.log(jg.jump(nums))