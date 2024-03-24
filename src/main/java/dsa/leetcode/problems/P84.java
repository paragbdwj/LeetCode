/*
84. Largest Rectangle in Histogram
Hard


Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
return the area of the largest rectangle in the histogram.



Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4


Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
 */
package dsa.leetcode.problems;


public class P84 {

    public int largestRectangleArea(int[] a) {
        int n = a.length;
        int leftInd = 0, rightInd = n - 1;
        int[][] indexes = new int[n][2];
        for(int i = 0; i < n; i++) {
            if(a[i] < a[leftInd]) {
                leftInd = i;
            }
            indexes[i][0] = leftInd;
        }

        for(int i = n - 1; i >= 0; i--) {
            if(a[i] < a[rightInd]) {
                rightInd = i;
            }
            indexes[i][1] = rightInd;
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int len = indexes[i][1] - indexes[i][0] - 1;
            ans = Math.max(ans, len * a[i]);
        }
        return ans;
    }
}
