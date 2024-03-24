/*
2150. Find All Lonely Numbers in the Array
Medium

You are given an integer array nums. A number x is lonely when it appears only once, and no adjacent numbers (i.e. x + 1 and x - 1) appear in the array.

Return all lonely numbers in nums. You may return the answer in any order.



Example 1:

Input: nums = [10,6,5,8]
Output: [10,8]
Explanation:
- 10 is a lonely number since it appears exactly once and 9 and 11 does not appear in nums.
- 8 is a lonely number since it appears exactly once and 7 and 9 does not appear in nums.
- 5 is not a lonely number since 6 appears in nums and vice versa.
Hence, the lonely numbers in nums are [10, 8].
Note that [8, 10] may also be returned.
Example 2:

Input: nums = [1,3,5,3]
Output: [1,5]
Explanation:
- 1 is a lonely number since it appears exactly once and 0 and 2 does not appear in nums.
- 5 is a lonely number since it appears exactly once and 4 and 6 does not appear in nums.
- 3 is not a lonely number since it appears twice.
Hence, the lonely numbers in nums are [1, 5].
Note that [5, 1] may also be returned.


Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 106
 */
package dsa.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P2150 {

    public List<Integer> findLonely(int[] a) {
        Map<Integer, Integer> integerExists = new HashMap<>();
        Arrays.stream(a).forEach(x -> integerExists.put(x, integerExists.getOrDefault(x,0) + 1));
        List<Integer> ans = new ArrayList<>();
        Arrays.stream(a).filter(x -> !(integerExists.containsKey(x - 1) || integerExists.containsKey(x + 1) || integerExists.get(x) > 1)).forEach(ans::add);
        return ans;
    }

}
