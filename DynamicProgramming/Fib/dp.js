// base case: 1 == 1, 2 == 1
// 状态 dp[n]
// 选择 


function fib(n) {
    if (n == 2 || n == 1) 
        return 1;
    let prev = 1, curr = 1;
    for (let i = 3; i <= n; i++) {
        let sum = prev + curr;
        prev = curr;
        curr = sum;
    }
    return curr;
}

for (let i = 1; i < 20; i++) {
    console.log(fib(i))
}
