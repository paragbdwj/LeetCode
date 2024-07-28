import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class OA {

    public static int minCostWithConstraints(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        dp[0][0] = grid[0][0] >= 0 ? grid[0][0] : Integer.MAX_VALUE;

        for (int i = 1; i < cols; i++) {
            if (grid[0][i] >= 0 && dp[0][i - 1] != Integer.MAX_VALUE) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            } else {
                dp[0][i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < rows; i++) {
            if (grid[i][0] >= 0 && dp[i - 1][0] != Integer.MAX_VALUE) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            } else {
                dp[i][0] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (grid[i][j] == -3) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else if (grid[i][j] >= 0) {
                    int minCost = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    if (minCost != Integer.MAX_VALUE) {
                        dp[i][j] = minCost + grid[i][j];
                    } else {
                        dp[i][j] = Integer.MAX_VALUE;
                    }
                } else if (grid[i][j] == -1) {
                    if (dp[i][j - 1] != Integer.MAX_VALUE) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = Integer.MAX_VALUE;
                    }
                } else if (grid[i][j] == -2) {
                    if (dp[i - 1][j] != Integer.MAX_VALUE) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        return dp[rows - 1][cols - 1] == Integer.MAX_VALUE ? -1 : dp[rows - 1][cols - 1];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        scanner.nextLine();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        int ans = minCostWithConstraints(matrix);
        System.out.println(ans == -1 ? "No Path" : ans);

    }
}
