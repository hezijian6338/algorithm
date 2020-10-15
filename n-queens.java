import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

class Queens {
    private List<String[][]> res = new LinkedList<>();

    public List<String[][]> solveNQueens(int n) {
        // "." 为空, "Q" 为放置皇后, 初始化空棋盘
       String[][] board = new String[n][n];
       for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
       }
       backtrack(board, 0);
       return res;
    }

    // board中那些小于 row的那些行, 都已经放置了皇后
    // 选择列表: 第 row行的所有列都是放置皇后的选择列表
    // 结束条件: row超过 board的最后一行
    public void backtrack(String[][] board, int row) {
        // System.out.println(row);
        if (row == board.length) {
            // System.out.println(board);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < row; j++) {
                    System.out.print(board[i][j]); 
                }
                System.out.println("");
            }
            System.out.println("---------");
            res.add(board.clone());
            return;
        }

        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                // System.out.println("isValid");
                continue;
            }
            // 做选择
            board[row][col] = "Q";
            // 进入下一行决策
            backtrack(board, row + 1);
            // 撤销选择
            board[row][col] = ".";
        }
    }

    public boolean isValid(String[][] board, int row, int col) {
        int n = board.length;
        // 检查是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == "Q") {
                return false;
            }
        }

        // 检查右上方是否冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == "Q") {
                return false;
            }
        }

        // 检查左上方是否冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == "Q") {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Queens q = new Queens();
        int n = 8;
        List<String[][]> res = q.solveNQueens(n);
        // System.out.println(res);

        // for (String[][] v : res) {
        //     // System.out.println(v);
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             System.out.print(v[i][j]); 
        //         }
        //         System.out.println("");
        //     }
        //     System.out.println("--------");
        // }
    }
}