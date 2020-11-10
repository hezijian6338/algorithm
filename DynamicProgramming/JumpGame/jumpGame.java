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

  public int jump(int[] nums) {
    int n = nums.length;
    int end = 0;
    int farthest = 0;
    int jumps = 0;

    for (int i = 0; i < n - 1; i++) {
      farthest = (nums[i] + i) > farthest ? (nums[i] + i) : farthest;

      if (end == i) {
        jumps++;
        end = farthest;
        // 若题目不保证一定能到终点, 则需要判断终止条件 (最远的距离所在的可跳步数是 0)
        // if (farthest == i) {
        //   return -1;
        // }
      }
    }

    return jumps;
  }

  public static void main(String[] args) {
    JumpGame jg = new JumpGame();
    int[] nums = {2, 3, 1, 1, 4};
    int[] _nums = {3, 2, 1, 0, 4};
    boolean res = jg.canJump(nums);
    boolean _res = jg.canJump(_nums);
    System.out.println(res);
    System.out.println(_res);
    System.out.println(jg.jump(nums));
  }
}