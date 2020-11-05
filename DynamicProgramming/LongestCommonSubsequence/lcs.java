class LongestCommonSubsequence {
  private String s1 = "";
  private String s2 = "";
  LongestCommonSubsequence(String s1, String s2) {
    this.s1 = s1;
    this.s2 = s2;
  }

  public int Recursion(int i, int j) {
    if (i == -1 || j == -1) {
      return 0;
    }
    
    if (this.s1.charAt(i) == this.s2.charAt(j)) {
      return this.Recursion(i - 1, j - 1) + 1;
    } else {
      return this.Recursion(i, j - 1) > this.Recursion(i - 1, j) ? this.Recursion(i, j - 1) : this.Recursion(i - 1, j);
    }

    // return this.Recursion(s1.length - 1, s2.length - 1);
  }

  public int lcs() {
    int[][] dp = new int[this.s1.length() + 1][this.s2.length() + 1];
    for (int i = 0; i < this.s1.length(); i++) {
      dp[i][0] = 0;
    }

    for (int i = 0; i < this.s2.length(); i++) {
      dp[0][i] = 0;
    }

    for (int i = 1; i < this.s1.length() + 1; i++) {
      for (int j = 1; j < this.s2.length() + 1; j++) {
        if (this.s1.charAt(i - 1) == this.s2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
        }
      }
    }

    return dp[this.s1.length()][this.s2.length()];
  }

  public static void main(String[] args) {
    String s1 = "abcde";
    String s2 = "ace";
    LongestCommonSubsequence lcs = new LongestCommonSubsequence(s1, s2);
    int res = lcs.Recursion(s1.length() - 1, s2.length() - 1);
    System.out.println(res);
    System.out.println(lcs.lcs());
  }
}