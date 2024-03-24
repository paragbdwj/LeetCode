/*
935. Knight Dialer
Medium

The chess knight has a unique movement, it may move two squares vertically and one square horizontally, or two squares horizontally and one square vertically
(with both forming the shape of an L). The possible movements of chess knight are shown in this diagaram:

A chess knight can move as indicated in the chess diagram below:


We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell (i.e. blue cell).


Given an integer n, return how many distinct phone numbers of length n we can dial.

You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 jumps to dial a number of length n. All jumps should be
valid knight jumps.

As the answer may be very large, return the answer modulo 109 + 7.



Example 1:

Input: n = 1
Output: 10
Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell of the 10 cells is sufficient.
Example 2:

Input: n = 2
Output: 20
Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
Example 3:

Input: n = 3131
Output: 136006598
Explanation: Please take care of the mod.


Constraints:

1 <= n <= 5000
 */
package dsa.leetcode.daily_problems;

public class P271123_935 {

    int[][] moves = {{-2, 1}, {2, 1}, {2, -1}, {-2, -1}, {-1, 2}, {-1, -2}, {1, 2}, {1, -2}};
    int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-2, 0, -2}};

    private static final int mod = (int) 1e9 + 7;

    int move(int i, int j, int len) {
        if (len == 0) {
            return 1;
        }
        if (!valid(i, j)) {
            return 0;
        }
        int ans = 0;
        for (int k = 0; k < 8; k++) {
            int ni = i + moves[k][0];
            int nj = j + moves[k][1];
            ans = (int) ((long) ans % mod + (long) move(ni, nj, len - 1) % mod) % mod;
        }
        return ans;
    }

    private boolean valid(int i, int j) {
        return i >= 0 && j >= 0 && i < 3 && j < 3 && board[i][j] >= 0;
    }

    public int knightDialer(int n) {
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] > 0) {
                    ans = (int) ((long) ans % mod + (long) move(i, j, n) % mod) % mod;

                }
            }
        }
        return ans;
    }
}
