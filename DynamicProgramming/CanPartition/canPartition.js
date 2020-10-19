class canPartition{
    constructor() {

    }

    CanPartition(nums) {
        let sum = 0

        for (let n of nums) {
            sum += n
        }

        console.log(sum)

        if (sum % 2 != 0) {
            return false
        }

        sum = sum / 2

        let size = nums.length

        let dp = []

        for (let i = 0; i <= size; i++) {
            let array = []
            for (let s = 0; s <= sum; s++) {
                if (s == 0)
                    array.push(true)
                else
                    array.push(false)
            }
            dp.push(array)
        }
        

        for (let i = 1; i <= size; i++) {
            for (let s = 1; s <= sum; s++) {
                if (s - nums[i - 1] >= 0) {
                    dp[i][s] = dp[i - 1][s - nums[i - 1]] || dp[i - 1][s]
                } else {
                    dp[i][s] = dp[i - 1][s]
                }
            }
        }

        return dp[size][sum]
    }
    
}

let cp = new canPartition()
console.log(cp.CanPartition([1, 5, 11, 5]))