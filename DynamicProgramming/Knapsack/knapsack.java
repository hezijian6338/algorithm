import java.util.HashMap;

/**
根据该网站学习并且编写: https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485064&idx=1&sn=550705eb67f5e71487c8b218382919d6&chksm=9bd7f880aca071962a5a17d0f85d979d6f0c5a5ce32c84b8fee88e36d451f9ccb3bb47b88f78&mpshare=1&scene=1&srcid=1015MFuGMgLE69gGGB7kpPSN&sharer_sharetime=1602723704054&sharer_shareid=75f4c16dc57d6f06b28e6a1a014735c4&rd2werd=1#wechat_redirect
*/

class Knapsack {
    public int result = 0;
    public int max = 0;

    public HashMap<String, Integer> memo = new HashMap<>();

    // 回溯法
    public void backtrack(int N, int W, int[] wt, int[] val, int i) {
        if (N <= 0 || W <= 0) {
            if (result > max)
                max = result;
            return;
        }

        // 装
        if (W - wt[i] >= 0) {
            // 选择
            result += val[i];
            // 递归
            backtrack(N - 1, W - wt[i], wt, val, i + 1);
            // 撤销选择
            result -= val[i];
        }


        // 不装
        // 选择 (价值没改变)
        result += 0;
        // 递归
        backtrack(N - 1, W, wt, val, i + 1);
        // 撤销选择 (价值没改变)
        result -= 0;
    }

    // 备忘录法 (凭感觉凑出来的)
    public int dp(int N, int W, int[] wt, int[] val, int i) {
        if (N < 0 || W < 0) {
            return 0;
        }

        String key = i + "," + W;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        Integer add = 0;

        if (W - wt[i] >= 0) {
            add = dp(N - 1, W - wt[i], wt, val, i + 1) + val[i];
        } else {
            add = dp(N - 1, W - wt[i], wt, val, i + 1);
        }

        Integer minus = dp(N - 1, W - wt[i], wt, val, i + 1);

        memo.put(key, add > minus ? add : minus);

        return add > minus ? add : minus;
    }

    // dp Table法
    public int knapsack(int N, int W, int[] wt, int[] val) {
        int[][] dp = new int[N + 1][W + 1];

        // basecase: 没有物品了
        for (int w = 0; w <= W; w++) {
            dp[0][w] = 0;
        }

        // basecase: 没有空间了
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = dp[i - 1][w] > (dp[i - 1][w - wt[i - 1]] + val[i - 1]) ? dp[i - 1][w] : (dp[i - 1][w - wt[i - 1]] + val[i - 1]);
                }
            }
        }

        return dp[N][W];
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();

        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};

        System.out.println(knapsack.knapsack(3, 4, wt, val));

        knapsack.backtrack(3, 4, wt, val, 0);
        System.out.println(knapsack.max);

        System.out.println(knapsack.dp(3, 4, wt, val, 0));
    }
}