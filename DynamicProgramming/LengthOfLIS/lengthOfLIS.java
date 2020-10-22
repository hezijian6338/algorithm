class LengthOfLIS {
  public int max = 0;
  public int tmp = 0;

  LengthOfLIS() {
    
  }

  public void backtrack(int[] nums, int i, int tmp) {

    System.out.println(tmp);
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

  public static void main(String[] args) {
    LengthOfLIS lis = new LengthOfLIS();

    int[] nums = {1, 4, 3, 6, 5};

    lis.backtrack(nums, nums.length - 1, 1);

    System.out.println(lis.max);
  }
}