/*
416. Partition Equal Subset Sum

Share
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both
subsets is equal or false otherwise.



Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.


Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100

 */
package dsa.problems.leetcode.problems;

import java.util.Arrays;

public class P416 {

//TODO: implement the function correctly
    public boolean canPartition(int[] nums) {
        int siz = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int[][] dp = new int[siz + 1][sum + 1];
        for (int i = 0; i <= siz; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }

        // base condition
        for (int i = 0; i <= siz; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= siz; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] |= dp[i][j - nums[i - 1]];
                }
            }
        }

        for (int i = 0; i <= siz; i++) {
            if (dp[i][sum / 2] == 1) {
                return true;
            }
        }
        return false;
    }

}
