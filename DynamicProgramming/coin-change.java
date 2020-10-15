import java.util.*;

class CoinChange {

    private List<Integer> coins = new ArrayList<>();
    private Map<Integer, Integer> memo = new HashMap<>();
    private Integer amount = 0;

    public CoinChange(List<Integer> coins, Integer amount) {
        this.coins = coins;
        this.amount = amount;
    }

    // 自顶向下
    public int dp(Integer n) {
        if (this.memo.containsKey(n)) {
            return this.memo.get(n);
        }

        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return -1;
        }

        Integer res = n + 1;

        for (Integer coin : this.coins) {
            Integer subproblem = dp(n - coin);
            if (subproblem == -1) {
                continue;
            }

            res = res < subproblem + 1 ? res : subproblem + 1;
        }

        memo.put(n, res != n + 1 ? res : -1);
        return memo.get(n);
    }

    public int solve() {
        return dp(this.amount);
    }

    // 自底向上
    public Integer _coinchange() {
        Map<Integer, Integer> memo = new HashMap<>();

        memo.put(0, 0);

        for (Integer i = 1; i <= this.amount; i++) {
            memo.put(i, this.amount + 1);
        }

        for (Integer i = 0; i < memo.size(); i++) {
            for (Integer coin : this.coins) {
                if (i - coin < 0) {
                    continue;
                }

                memo.replace(i, memo.get(i) < (memo.get(i - coin) + 1) ? memo.get(i) : (memo.get(i - coin) + 1));
            }
        }
        
        return memo.get(this.amount) == (this.amount + 1) ? -1 : memo.get(this.amount);
    }

    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>();
        int amount = 10;

        coins.add(1);
        coins.add(2);
        coins.add(5);

        CoinChange cc = new CoinChange(coins, amount);
        System.out.println(cc.solve());
        System.out.println(cc._coinchange());
    }
}