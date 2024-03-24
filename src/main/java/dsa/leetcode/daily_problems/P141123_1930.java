/*
1930. Unique Length-3 Palindromic Subsequences
Medium

Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.

A palindrome is a string that reads the same forwards and backwards.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of
the remaining characters.

For example, "ace" is a subsequence of "abcde".


Example 1:

Input: s = "aabca"
Output: 3
Explanation: The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "aabca")
- "aaa" (subsequence of "aabca")
- "aca" (subsequence of "aabca")
Example 2:

Input: s = "adc"
Output: 0
Explanation: There are no palindromic subsequences of length 3 in "adc".
Example 3:

Input: s = "bbcbaba"
Output: 4
Explanation: The 4 palindromic subsequences of length 3 are:
- "bbb" (subsequence of "bbcbaba")
- "bcb" (subsequence of "bbcbaba")
- "bab" (subsequence of "bbcbaba")
- "aba" (subsequence of "bbcbaba")


Constraints:

3 <= s.length <= 105
s consists of only lowercase English letters.
 */

package dsa.leetcode.daily_problems;

import dsa.leetcode.helper.FastReader;
import dsa.leetcode.helper.FastWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//TODO: Solve error in the code
public class P141123_1930 {
    public static int countPalindromicSubsequence(String s) {
        int n = s.length();
        Map<Character, Integer> rightCharacterIntegerMap = new HashMap<>();
        HashSet<String> strings = new HashSet<>();
        for (int i = n - 1; i > 0; i--) {
            rightCharacterIntegerMap.put(s.charAt(i), rightCharacterIntegerMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        Map<Character, Integer> leftCharacterIntegerMap = new HashMap<>();
        for (int i = 1; i < n - 1; i++) {
            leftCharacterIntegerMap.put(s.charAt(i - 1), leftCharacterIntegerMap.getOrDefault(s.charAt(i - 1), 0) + 1);
            rightCharacterIntegerMap.put(s.charAt(i), rightCharacterIntegerMap.getOrDefault(s.charAt(i), 0) - 1);
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);
                if (leftCharacterIntegerMap.getOrDefault(c, 0) > 0 && rightCharacterIntegerMap.getOrDefault(c, 0) > 0) {
                    strings.add(String.valueOf(c + s.charAt(i) + c));
                }
            }
        }
        return strings.size();
    }

    public static void main(String[] args) throws IOException {
            FastReader reader = new FastReader();
            FastWriter writer = new FastWriter();
            int testCases = 1;
            while (testCases-- > 0) {
                // write output commands here
                String s = reader.nextLine();
                int x = countPalindromicSubsequence(s);
                writer.print(x);
            }
            writer.close();
        }
}
