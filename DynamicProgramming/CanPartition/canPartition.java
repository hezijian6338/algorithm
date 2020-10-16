class CanPartition {
    public Boolean canPartition(Integer[] nums) {
        Integer size = nums.length;
        Integer sum = 0;

        for (Integer num : nums) {
            sum = num + sum;
        }

        if (sum % 2 != 0) {
            return false;
        }

        sum = sum / 2;

        Boolean[][] dp = new Boolean[size + 1][sum + 1];

        for (int i = 0; i <= size; i++) {
            dp[i][0] = true;
        }

        for (int i = 0; i <= size; i++) {
            for (int s = 1; s <= sum; s++) {
                dp[i][s] = false;
                // System.out.print(dp[i][s]);
            }
            // System.out.println("");
        }

        for (int i = 1; i <= size; i++) {
            for (int s = 1; s <= sum; s++) {
                if (s - nums[i - 1] >= 0) {
                    dp[i][s] = dp[i - 1][s - nums[i - 1]] || dp[i - 1][s];
                } else {
                    dp[i][s] = dp[i - 1][s];
                }
            }
        }
        return dp[size][sum];
    }

    public static void main(String[] args) {
        CanPartition cp = new CanPartition();

        Integer[] nums = {1, 5, 11, 5};

        System.out.println(cp.canPartition(nums));
    }
}