/*
1980. Find Unique Binary String
Medium

Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does
not appear in nums. If there are multiple answers, you may return any of them.



Example 1:

Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.
Example 2:

Input: nums = ["00","01"]
Output: "11"
Explanation: "11" does not appear in nums. "10" would also be correct.
Example 3:

Input: nums = ["111","011","001"]
Output: "101"
Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.


Constraints:

n == nums.length
1 <= n <= 16
nums[i].length == n
nums[i] is either '0' or '1'.
All the strings of nums are unique.
 */

package dsa.leetcode.daily_problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class P161123_1980 {
    private int n;
    private HashSet<String> stringSet;
    private String ans;

    void rec(int ind, String s) {
        if (!"-1".equals(ans)) {
            return;
        }
        if (ind == n) {
            if (stringSet.contains(s)) {
                return;
            }
            ans = s;
            return;
        }
        rec(ind + 1, s + "0");
        rec(ind + 1, s + "1");
    }

    public String findDifferentBinaryString(String[] nums) {
        List<String> numsList = Arrays.asList(nums);
        this.stringSet = new HashSet<>(numsList);
        this.n = nums[0].length();
        this.ans = "-1";
        rec(0, "");
        return this.ans;
    }
}
