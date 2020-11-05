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

  public static void main(String[] args) {
    String s1 = "abcde";
    String s2 = "ace";
    LongestCommonSubsequence lcs = new LongestCommonSubsequence(s1, s2);
    int res = lcs.Recursion(s1.length() - 1, s2.length() - 1);
    System.out.println(res);
  }
}