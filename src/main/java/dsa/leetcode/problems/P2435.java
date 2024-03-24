/*
2435. Paths in Matrix Whose Sum Is Divisible by K
Hard

837

28

Add to List

Share
You are given a 0-indexed m x n integer matrix grid and an integer k. You are currently at position (0, 0)
and you want to reach position (m - 1, n - 1) moving only down or right.

Return the number of paths where the sum of the elements on the path is divisible by k. Since the answer may be
very large, return it modulo 109 + 7.



Example 1:


Input: grid = [[5,2,4],[3,0,5],[0,7,2]], k = 3
Output: 2
Explanation: There are two paths where the sum of the elements on the path is divisible by k.
The first path highlighted in red has a sum of 5 + 2 + 4 + 5 + 2 = 18 which is divisible by 3.
The second path highlighted in blue has a sum of 5 + 3 + 0 + 5 + 2 = 15 which is divisible by 3.
Example 2:


Input: grid = [[0,0]], k = 5
Output: 1
Explanation: The path highlighted in red has a sum of 0 + 0 = 0 which is divisible by 5.
Example 3:


Input: grid = [[7,3,4,9],[2,3,6,2],[2,3,7,0]], k = 1
Output: 10
Explanation: Every integer is divisible by 1 so the sum of the elements on every possible path is divisible by k.


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 5 * 104
1 <= m * n <= 5 * 104
0 <= grid[i][j] <= 100
1 <= k <= 50
 */

package dsa.leetcode.problems;

public class P2435 {
    int[][] grid;
    int k, n, m;
    int[][][] dp;
    private static final int mod = (int) 1e9 + 7;

    int noOfPaths(int x, int y, int sum) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 0;
        }

        if (dp[x][y][sum] != -1) {
            return dp[x][y][sum];
        }

        if (x == m - 1 && y == n - 1 &&  ((sum + grid[x][y]) % k == 0)) {
            return dp[x][y][sum] = 1;
        }

        return dp[x][y][sum] = (int) ((long) noOfPaths(x + 1, y, (sum + grid[x][y]) % k) % mod + (long) noOfPaths(x, y + 1, (sum + grid[x][y]) % k) % mod) % mod;
    }

    public int numberOfPaths(int[][] grid, int k) {
        this.grid = grid;
        this.k = k;
        this.m = grid.length;
        this.n = grid[0].length;
        this.dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int ii = 0; ii <= k; ii++) {
                    dp[i][j][ii] = -1;
                }
            }
        }
        return noOfPaths(0, 0, 0);
    }
}
