/**
根据该网站学习并且编写: https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/zui-da-zi-shu-zu
*/

class MaxSubArray {

  public int maxSubArray(int[] nums) {
    int size = nums.length;
    int[] dp = new int[size];

    if (size == 0)
      return 0;

    dp[0] = nums[0];
    for (int i = 1; i < size; i++) {
      dp[i] = nums[i] > (dp[i - 1] + nums[i]) ? nums[i] : (dp[i - 1] + nums[i]);
    }

    int max = 0;
    for (int i = 0; i < size; i++) {
      // System.out.println(dp[i]);
      if (dp[i] > max) {
        max = dp[i];
      }
    }

    return max;
  }

  public static void main(String[] args) {
    MaxSubArray msa = new MaxSubArray();
    int[] nums = {-3, 4, -1, 2, -6, 1, 4};
    int max = msa.maxSubArray(nums);
    System.out.println(max);
  }
}