/*
695. Max Area of Island
Medium

You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You
may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.



Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],
[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
 */

package dsa.leetcode.problems;

public class P695 {

    int[][] dir = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    int[][] vis, grid;
    int ctr, n, m;

    void dfs(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < m) {
            if (vis[x][y] == 1 || grid[x][y] == 0) {
                return;
            }
        } else {
            return;
        }
        vis[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            dfs(nx, ny);
        }
        ctr++;
    }

    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        vis = new int[n][m];
        ctr = 0;
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ctr = 0;
                if (vis[i][j] != 1) {
                    dfs(i, j);
                    ans = Math.max(ans, ctr);
                }
            }
        }
        return ans;
    }
}
