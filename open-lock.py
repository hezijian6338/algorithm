# 该版本为优化死亡队列的版本~
def bfs():
    def plusOne(s, i):
        n = ''
        if s[i] == '9':
            n = s[:i] + '0' + s[i + 1:]
        else:
            n = s[:i] + str(int(s[i]) + 1) + s[i + 1:]

        return n

    def minusOne(s, i):
        n = ''
        if s[i] == '0':
            n = s[:i] + '9' + s[i + 1:]
        else:
            n = s[:i] + str(int(s[i]) - 1) + s[i + 1:]

        return n

    def openLock(deadends, target):
        visited = []

        for s in range(len(deadends)):
            visited.append(deadends[s])

        step = 0

        queen = []

        queen.append('0000')

        while len(queen) > 0:
            sz = len(queen)

            for i in range(sz):
                cur = queen.pop(0)

                if cur == target:
                    return step
                if cur in visited:
                    continue

                visited.append(cur)

                for j in range(4):
                    plus = plusOne(cur, j)
                    minus = minusOne(cur, j)

                    if plus not in visited:
                        queen.append(plus)

                    if minus not in visited:
                        queen.append(minus)

            step = step + 1

        return -1

    return openLock(["0201", "0101", "0102", "1212", "2002"], "0202")


print(bfs())
