import java.util.HashMap;

/**
根据该网站学习并且编写: https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/bian-ji-ju-li
*/

class MinDistance {

  private String s1 = "";
  private String s2 = "";
  private HashMap<String, Integer> memo = new HashMap<>();

  public int min = 999;
  private int tmp = 0;

  MinDistance(String s1, String s2) {
    this.s1 = s1;
    this.s2 = s2;
  }

  // 经典回溯法 (框架推出)
  public void Backtrack(int i, int j) {

    // 由于跳出函数的条件添加结果的数量存在跳跃, 导致再撤销选择的时候会出现不对等, 所以这里处理为一个临时的变量, 只求最后的 min值正确即可~
    // basecase
    if (i == -1) {
      int _tmp = this.tmp + j + 1;
      if (_tmp < this.min)
        this.min = _tmp;
      return;
    }

    // basecase
    if (j == -1) {
      int _tmp = this.tmp + i + 1;
      if (_tmp < this.min)
        this.min = _tmp;
      return;
    }

    if (this.s1.charAt(i) == this.s2.charAt(j)) {
      // do noting
      Backtrack(i - 1, j - 1);
    } else {
        this.tmp += 1;
        Backtrack(i, j - 1);
        this.tmp -= 1;

        this.tmp += 1;
        Backtrack(i - 1, j);
        this.tmp -= 1;

        this.tmp += 1;
        Backtrack(i - 1, j - 1);
        this.tmp -= 1;
    }
  }

  // 递归法 (文章描述)
  public int Recursion(int i, int j) {
    if (i == -1) {
      return j + 1;
    }

    if (j == -1) {
      return i + 1;
    }

    if (this.s1.charAt(i) == this.s2.charAt(j)) {
      return Recursion(i - 1, j - 1);
    } else {
      int insert = Recursion(i, j - 1) + 1;
      int delete = Recursion(i - 1, j) + 1;
      int replace = Recursion(i - 1, j - 1) + 1;
      return (insert<delete?insert:delete)<replace?(insert<delete?insert:delete):replace;
    }
  }

  // 备忘录法
  public int dp(int i, int j) {
    String key = i + "," + j;
    if (this.memo.containsKey(key)) {
      return this.memo.get(key);
    }

    if (i == -1) {
      this.memo.put(key, new Integer(j + 1));
      return j + 1;
    }

    if (j == -1) {
      this.memo.put(key, new Integer(i + 1));
      return i + 1;
    }

    if (this.s1.charAt(i) == this.s2.charAt(j)) {
      return dp(i - 1, j - 1);
    } else {
      int insert = Recursion(i, j - 1) + 1;
      int delete = Recursion(i - 1, j) + 1;
      int replace = Recursion(i - 1, j - 1) + 1;
      return (insert < delete ? insert : delete) < replace ? (insert < delete ? insert : delete) : replace;
    }
  }

  // dp Table法
  public Integer _MinDistance() {
    int _s1 = this.s1.length();
    int _s2 = this.s2.length();

    Integer[][] _dp = new Integer[_s1 + 1][_s2 + 1];

    for (int i = 0; i <= _s2; i++) {
      _dp[0][i] = i;
    }

    for (int i = 0; i <= _s1; i++) {
      _dp[i][0] = i;
    }

    for (int i = 1; i <= _s1; i++) {
      for (int j = 1; j <= _s2; j++) {
        if (this.s1.charAt(i - 1) == this.s2.charAt(j - 1)) {
          _dp[i][j] = _dp[i - 1][j - 1];
        } else {

          int insert = _dp[i][j - 1] + 1;
          int delete = _dp[i - 1][j] + 1;
          int replace = _dp[i - 1][j - 1] + 1;

          _dp[i][j] = (insert < delete ? insert : delete) < replace ? (insert < delete ? insert : delete) : replace;
        }
      }
    }

    // for (int i = 0; i <= _s1; i++) {
    //   for (int j = 0; j <= _s2; j++) {
    //     System.out.print(_dp[i][j]);
    //   }
    //   System.out.println("");
    // }

    return _dp[_s1][_s2];
  }

  public static void main(String[] args) {
    String s1 = "horse";
    String s2 = "ros";
    MinDistance md = new MinDistance("horse", "ros");
    md.Backtrack(s1.length() - 1, s2.length() - 1);
    System.out.println(md.min);
    System.out.println(md.Recursion(s1.length() - 1, s2.length() - 1));
    System.out.println(md.dp(s1.length() - 1, s2.length() - 1));
    System.out.println(md._MinDistance());
  }
}