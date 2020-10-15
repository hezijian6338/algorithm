def fib(n):
    if n == 1 | n == 2:
        return 1
    
    pre = 1
    curr = 1
    for i in range(3, n + 1):
        _sum = pre + curr
        curr = _sum
        pre = curr
    return curr

for i in range(1, 8):
    print(fib(i))