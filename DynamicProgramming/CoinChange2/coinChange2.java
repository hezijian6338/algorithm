class CoinChange2 {
  public int coinChange2(int[] coins, int amount) {
    int[][] dp = new int[coins.length + 1][amount + 1];
    for (int i = 0; i < amount + 1; i++) {
      dp[0][i] = 0;
    }

    for (int i = 0; i < coins.length + 1; i++) {
      dp[i][0] = 1;
    }

    for (int i = 1; i < coins.length + 1; i++) {
      for (int j = 1; j < amount + 1; j++) {
        if (j - coins[i - 1] >= 0) {
          dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[coins.length][amount];
  }

  public static void main(String[] args) {
    CoinChange2 cc2 = new CoinChange2();
    int[] coins = {1, 2, 5};
    int amount = 5;
    int res = cc2.coinChange2(coins, amount);
    System.out.println(res);
  }
}