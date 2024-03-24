/*
1424. Diagonal Traverse II
Medium

Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.



Example 1:


Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]
Example 2:


Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]


Constraints:

1 <= nums.length <= 105
1 <= nums[i].length <= 105
1 <= sum(nums[i].length) <= 105
1 <= nums[i][j] <= 105
 */
package dsa.leetcode.daily_problems;

import dsa.leetcode.helper.FastReader;
import dsa.leetcode.helper.FastWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P221123_1424 {
    public static int[] findDiagonalOrder(List<List<Integer>> a) {
        int n = a.size();
        List<List<Integer>> vec = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            vec.add(new ArrayList<>());
        }
        int numOfElements = 0;
        for (int i = n - 1; i >= 0; i--) {
            int ctr = 0;
            for (int j : a.get(i)) {
                if(vec.size() == i + ctr + 1) {
                    vec.add(new ArrayList<>());
                }
                vec.get(i + ctr).add(a.get(i).get(ctr));
                ctr++;
                numOfElements++;
            }
        }

        int[] ans = new int[numOfElements];
        int ctr = 0;
        for (List<Integer> i: vec) {
            for (int j : i) {
                ans[ctr++] = j;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
            FastReader reader = new FastReader();
            FastWriter writer = new FastWriter();
            int testCases = 1;
            while (testCases-- > 0) {
                // write output commands here
                String s = reader.nextLine();
                int n = s.length();
                List<List<Integer>> list = new ArrayList<>();
                for(int i = 1; i < n - 1; i++) {
                    if(s.charAt(i)==' ' || s.charAt(i) == ',' || s.charAt(i) == ']') {
                        continue;
                    }
                    if(s.charAt(i) == '[') {
                        list.add(new ArrayList<>());
                        continue;
                    }
                    list.get(list.size() -1).add(s.charAt(i) - '0');
                }
                writer.print(findDiagonalOrder(list));
            }
            writer.close();
        }
}
