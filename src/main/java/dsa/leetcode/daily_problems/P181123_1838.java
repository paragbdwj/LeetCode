/*
1838. Frequency of the Most Frequent Element
Medium

The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment
the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.



Example 1:

Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3.
Example 2:

Input: nums = [1,4,8,13], k = 5
Output: 2
Explanation: There are multiple optimal solutions:
- Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
- Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
- Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
Example 3:

Input: nums = [3,9,6], k = 2
Output: 1


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105
1 <= k <= 105
 */
package dsa.leetcode.daily_problems;

import java.util.Arrays;

public class P181123_1838 {
    int k, n;
    int[] a, pref;

    boolean doesContainFrequencyK(int len) {
        for (int i = 0; i + len <= n; i++) {
            if (len * a[i + len - 1] - (pref[i + len] - pref[i]) <= k) {
                return true;
            }
        }
        return false;
    }

    // [i],[i+1],[i+2],[i+3]
    // 1 -> 0
    // 2 -> 0 + 1
    // 3 -> 0 + 1 + 2

    public int maxFrequency(int[] a, int k) {
        Arrays.sort(a);
        this.a = a;
        this.k = k;
        this.n = a.length;
        pref = new int[n + 1];
        pref[0] = 0;
        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1] + a[i - 1];
        }
        int ans = 1;
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (doesContainFrequencyK(mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

}

/*
Brainstorming :

1 2 4 8  , k = 5
currK = 5, start = 0, end = 1, currVal = a[0];

while () {
       while( (end - start) * (a[end] - currVal) > currK) {
            currK += currVal - a[start];
            start++;
       }
}

Simply use sliding window with binary search
 */
