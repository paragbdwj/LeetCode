/*
1846. Maximum Element After Decreasing and Rearranging
Medium

You are given an array of positive integers arr. Perform some operations (possibly none) on arr so that it satisfies these conditions:

The value of the first element in arr must be 1.
The absolute difference between any 2 adjacent elements must be less than or equal to 1. In other words, abs(arr[i] - arr[i - 1]) <= 1 for each i
where 1 <= i < arr.length (0-indexed). abs(x) is the absolute value of x.
There are 2 types of operations that you can perform any number of times:

Decrease the value of any element of arr to a smaller positive integer.
Rearrange the elements of arr to be in any order.
Return the maximum possible value of an element in arr after performing the operations to satisfy the conditions.

Example 1:

Input: arr = [2,2,1,2,1]
Output: 2
Explanation:
We can satisfy the conditions by rearranging arr so it becomes [1,2,2,2,1].
The largest element in arr is 2.
Example 2:

Input: arr = [100,1,1000]
Output: 3
Explanation:
One possible way to satisfy the conditions is by doing the following:
1. Rearrange arr so it becomes [1,100,1000].
2. Decrease the value of the second element to 2.
3. Decrease the value of the third element to 3.
Now arr = [1,2,3], which satisfies the conditions.
The largest element in arr is 3.
Example 3:

Input: arr = [1,2,3,4,5]
Output: 5
Explanation: The array already satisfies the conditions, and the largest element is 5.


Constraints:

1 <= arr.length <= 105
1 <= arr[i] <= 109

 */
package dsa.leetcode.daily_problems;

import java.util.Arrays;

public class P151123_1846 {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int siz = arr.length;
        if(siz == 1) {
            return 1;
        }
        arr[0] = 1;
        int ans = 1;
        for(int i = 1; i <  siz; i++) {
            if(arr[i] == arr[i-1]) {
                continue;
            }
            arr[i] = arr[i-1] + 1;
            ans = Math.max(ans, arr[i]);
        }
        return ans;
    }

}

//        while (start <= end) {
//            if (flicker == 0) {
//                a[start++] = arr[ctr++];
//            } else {
//                a[end--] = arr[ctr++];
//            }
//            flicker ^= 1;
//        }
//
//        a[0] = 1;
//
//        for(int i = 1; i < siz; i++) {
//            int diff = a[i] - a[i - 1];
//            if(Math.abs(diff) <= 1) {
//                continue;
//            }
//            a[i] = a[i-1] + 1;
//        }
//
//        a[siz - 1] = 1;
//        for(int i = siz - 2; i >= 1; i--) {
//            int diff = a[i] - a[i + 1];
//            if(Math.abs(diff) <= 1) {
//                continue;
//            }
//            a[i] = a[i+1] + 1;
//        }
//        assert a[1] == 1 || a[1] == 2;