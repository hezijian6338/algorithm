import java.util.*;

class MinInsertions {
    
    public Integer calc(String str) {
        int size = str.length();

        Integer[][] dp = new Integer[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = size - 2; i >= 0; i--) {
            for (int j = i + 1; j < size; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = dp[i + 1][j] < dp[i][j - 1] ? (dp[i + 1][j] + 1): (dp[i][j - 1] + 1);
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j == 0) {
                    System.out.print("[" + dp[i][j] + ", ");
                }
                else if (j == size - 1) {
                    System.out.print(dp[i][j] + "]");
                } else {
                    System.out.print(dp[i][j] + ", ");
                }
                
            }
            System.out.println("");
        }

        return dp[0][size - 1];

    }

    public static void main(String[] args) {
        MinInsertions mi = new MinInsertions();
        System.out.print(mi.calc("sbaddadabs"));
    }


}