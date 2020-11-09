class JumpGame {
  public boolean canJump(int[] nums) {
    int n = nums.length;
    int farthest = 0;

    for (int i = 0; i < n - 1; i++) {
      if (nums[i] + i > farthest) {
        farthest = nums[i] + i;
      }
      if (farthest <= i)
        return false;
    }

    return farthest >= n - 1;
  }
}