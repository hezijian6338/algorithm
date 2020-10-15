public class dp{
	static int fib(int N) {
		/**
		vector<int> dep = new vector(N + 1, 0);
		// base case
		dp[1] = dp[2] = 1;
		for (int i = 3; i <= N; i++)
			dp[i] = dp[i - 1] + dp[i - 2];
		return dp[N];
		**/
		return 1;
	}
	static int _fib(int n) {
		if (n == 2 || n == 1)
			return 1;
		int prev = 1, curr = 1;
		for (int i = 3; i <= n; i ++) {
			int sum = prev + curr;
			prev = curr;
			curr = sum;
		}
		return curr;
	}
	public static void main(String[] args) {
		// dp t = new dp();
		System.out.print(dp._fib(20));
	}
}
