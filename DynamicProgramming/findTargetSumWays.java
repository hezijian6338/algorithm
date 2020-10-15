import java.util.HashMap;

/** 
    根据该网站学习并且编写: https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/targetsum
*/

class FindTargetSumWays {
    public int result = 0;

    public HashMap<String, Integer> memo = new HashMap<>();

    // 回溯法, 存在重叠子问题
    public void backtrack(int[] nums, int i, int rest) {
        if (i == nums.length) {
            if (rest == 0) {
                result++;
            }
            return;
        }

        backtrack(nums, i + 1, rest - nums[i]);
        backtrack(nums, i + 1, rest + nums[i]);
    }

    // 备忘录方法, 动态规划
    public Integer dp(int[] nums, int i, int rest) {
        if (i == nums.length) {
            if (rest == 0) {
                return 1;
            }
            return 0;
        }

        String key = i + "," + rest;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        Integer res = dp(nums, i + 1, rest - nums[i]) + dp(nums, i + 1, rest + nums[i]);
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        FindTargetSumWays ftsw = new FindTargetSumWays();

        int[] nums = {1, 1, 1, 1, 1};

        ftsw.backtrack(nums, 0, 3);

        System.out.println(ftsw.result);

        System.out.println(ftsw.dp(nums, 0, 3));
    }
}