class LengthOfLIS {
  public int max = 0;
  public int tmp = 1;

  LengthOfLIS() {
    
  }

  public void backtrack(int[] nums, int i, int j) {
    if (j == 0) {
      System.out.println(this.tmp);
      if (this.tmp > this.max) {
        this.max = this.tmp;
      }
      return;
    }

    for (j = j - 1; j >= 0; j--) {
      if (nums[j] < nums[i]) {
        this.tmp += 1;
        backtrack(nums, i - 1, j);
        this.tmp -= 1;
      } else {
        backtrack(nums, i, j - 1);
      }
    }
  }

  public static void main(String[] args) {
    LengthOfLIS lis = new LengthOfLIS();

    int[] nums = {1, 4, 3, 4, 2};

    lis.backtrack(nums, nums.length - 1, nums.length - 1);

    System.out.println(lis.max);
  }
}