/*
1814. Count Nice Pairs in an Array
Medium

You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x. For example, rev(123) = 321, and rev(120) = 21.
A pair of indices (i, j) is nice if it satisfies all of the following conditions:

0 <= i < j < nums.length
nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.



Example 1:

Input: nums = [42,11,1,97]
Output: 2
Explanation: The two pairs are:
 - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
 - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
Example 2:

Input: nums = [13,10,35,24,76]
Output: 4


Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109
*/

package dsa.leetcode.daily_problems;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P211123_1841 {
    private static final int mod = (int) 1e9 + 7;

    public static int countNicePairs(int[] a) {
        int n = a.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] -= Integer.parseInt(new StringBuffer(String.valueOf(a[i])).reverse().toString());
            freqMap.put(a[i], freqMap.getOrDefault(a[i], 0) + 1);
        }
        long ans = 0;
        for (Integer key : freqMap.keySet()) {
            int x = freqMap.get(key);
            ans += (long) x * (x - 1) / 2;
        }
        return (int) (ans % mod);
    }

    public static void main(String[] args) {
        int[] a = {42,11,1,97};
        countNicePairs(a);
    }
}
