import java.util.HashMap;
import java.util.Arrays;

/**
根据该网站学习并且编写: https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485269&idx=1&sn=571a6366b0b592f103971ae3e119998b&chksm=9bd7f95daca0704be3c5c839cd96ab1a94efaefb48fa3101522a02fa19af9ef48170e03cd817&mpshare=1&scene=1&srcid=1019x3mKUXSJdEpVRvE8MIbe&sharer_sharetime=1603104666692&sharer_shareid=75f4c16dc57d6f06b28e6a1a014735c4&rd2werd=1#wechat_redirect
*/

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
      return tmp;
    }

    for (int j = i - 1; j >= 0; j--) {
      if (nums[j] < nums[i]) {
        int res = (this.dp(nums, j, tmp) + 1);
        this.memo.put(i, res);
        return res;
      } else {
        int res = this.dp(nums, j, tmp);
        this.memo.put(i, res);
        return res;
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

    System.out.println(lis.memo);
  }
}