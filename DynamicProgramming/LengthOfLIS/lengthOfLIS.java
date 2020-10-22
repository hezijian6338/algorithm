import java.util.HashMap;
import java.util.Arrays;

class LengthOfLIS {
  public int max = 0;
  public HashMap<Integer, Integer> memo = new HashMap<>();

  LengthOfLIS() {
    
  }

  public void backtrack(int[] nums, int i, int tmp) {

    if (tmp > this.max) {
      this.max = tmp;
    }

    if (i == 0) {
      return;
    }

    for (int k = i - 1; k >= 0; k--) {
      if (nums[k] < nums[i]) {
        tmp += 1;
        backtrack(nums, k, tmp);
        tmp -= 1;
      } else {
        backtrack(nums, k, 1);
      }
    }
  }

  public int dp(int[] nums, int i, int tmp) {
    this.max = 0;

    if (this.memo.containsKey(i)) {
      return this.memo.get(i);
    }

    if (tmp > this.max) {
      this.max = tmp;
    }

    if (i == 0) {
      this.memo.put(i, tmp);
      System.out.println(this.memo);
      return tmp;
    }

    for (int j = i - 1; j >= 0; j--) {
      if (nums[j] < nums[i]) {
        int res = (this.dp(nums, j, tmp) + 1);
        return res;
      } else {
        return this.dp(nums, j, tmp);
      }
    }

    return this.dp(nums, i, tmp);
  }

  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = dp[i] > (dp[j] + 1) ? dp[i] : (dp[j] + 1);
        }
      }
    }

    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      res = res > dp[i] ? res : dp[i];
    }
    
    return res;
  }

  public static void main(String[] args) {
    LengthOfLIS lis = new LengthOfLIS();

    int[] nums = {1, 4, 3, 6, 5};

    lis.backtrack(nums, nums.length - 1, 1);

    System.out.println(lis.max);

    System.out.println(lis.dp(nums, nums.length - 1, 1));

    System.out.println(lis.lengthOfLIS(nums));

    // System.out.println(lis.memo);
  }
}