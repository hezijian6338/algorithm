import java.util.*;

class bfs {
    public String plusOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '9') {
            ch[i] = '0';
        } else {
            ch[i] += 1;
        }

        return new String(ch);
    }

    public String minusOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '0') {
            ch[i] = '9';
        } else {
            ch[i] -= 1;
        }

        return new String(ch);
    }

    public int openLock(String[] deadends, String target) {
        // 加载死亡组合
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }

        // 配置已尝试的组合
        Set<String> visited = new HashSet<>();

        Queue<String> q = new LinkedList<>();

        // 记录步数
        int step = 0;
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int sz = q.size();

            // 遍历队列的节点
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();

                // 检查是否就是结果 (跳出循环)
                if (cur.equals(target)) {
                    return step;
                }
                // 检查是否在死亡队列中
                if (deads.contains(cur)) {
                    continue;
                }

                for (int j = 0; j < 4; j++) {
                    // 向上拨一下
                    String up = plusOne(cur, j);
                    // 向下拨一下
                    String down = minusOne(cur, j);

                    // 检查是否曾经尝试过这个组合
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }

                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
                
            }
            // 步数加 1
            step++;
        }
        // 如果上面都没有返回, 到这里返回. 即是所有结果都不符合, 返回 -1
        return -1;
    }

    public static void main(String[] args) {
        bfs b = new bfs();
        String[] deadlists = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        int res = b.openLock(deadlists, "8888");
        System.out.println(res);
    }
}