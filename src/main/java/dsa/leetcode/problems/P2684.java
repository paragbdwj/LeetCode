/*
2684. Maximum Number of Moves in a Grid
Medium

You are given a 0-indexed m x n matrix grid consisting of positive integers.

You can start at any cell in the first column of the matrix, and traverse the grid in the following way:

From a cell (row, col), you can move to any of the cells: (row - 1, col + 1), (row, col + 1) and (row + 1, col + 1) such that the value of the cell you move to, should be
strictly bigger than the value of the current cell.
Return the maximum number of moves that you can perform.



Example 1:


Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
Output: 3
Explanation: We can start at the cell (0, 0) and make the following moves:
- (0, 0) -> (0, 1).
- (0, 1) -> (1, 2).
- (1, 2) -> (2, 3).
It can be shown that it is the maximum number of moves that can be made.
Example 2:


Input: grid = [[3,2,4],[2,1,9],[1,1,7]]
Output: 0
Explanation: Starting from any cell in the first column we cannot perform any moves.


Constraints:

m == grid.length
n == grid[i].length
2 <= m, n <= 1000
4 <= m * n <= 105
1 <= grid[i][j] <= 106
*/

package dsa.leetcode.problems;


// Multi Source BFS







import ch.qos.logback.core.joran.sanity.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class P2684 {

    static class Cell {
        public int x;
        public int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maxMoves(int[][] a) {
        int n = a.length, m = a[0].length;
        int[][] dist = new int[n][m];

        Queue<Cell> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            dist[i][0] = 1;
            q.add(new Cell(i, 0));
        }

        int[][] directions = {{-1, 1}, {1, 1}, {0, 1}};
        int ans = 0;
        while (!q.isEmpty()) {
            Cell cell = q.poll();
            for (int[] dir : directions) {
                int nx = cell.x + dir[0];
                int ny = cell.y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && a[nx][ny] > a[cell.x][cell.y] && dist[nx][ny] < (1 + dist[cell.x][cell.y])) {
                    dist[nx][ny] = 1 + dist[cell.x][cell.y];
                    q.add(new Cell(nx, ny));
                }

            }
            ans = Math.max(ans, dist[cell.x][cell.y]);
        }
        return ans - 1;
    }
}
