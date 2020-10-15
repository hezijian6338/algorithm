import java.util.LinkedList;
import java.util.Queen;
import javax.swing.tree.TreeNode;

class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queen<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // 根节点本为一层, 所以初始化为 1
        int depth = 1;

        while(!q.isEmpty()) {
            int sz = q.size();

            // 将当前队列的节点, 向四周扩散
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();

                // 判断是否到达终点
                if (cur.left == null && cur.right == null) {
                    return depth;
                }

                // 把 cur的相邻节点添加进队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }

            // 增加步数
            depth++;
        }

    return depth;
    }

    public void static main(String[] args) {
        
    }
}