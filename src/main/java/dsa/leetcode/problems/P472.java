/*
472. Concatenated Words
Hard

Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.

A concatenated word is defined as a string that is comprised entirely of at least two shorter words (not necessarily
distinct) in the given array.



Example 1:

Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
"dogcatsdog" can be concatenated by "dog", "cats" and "dog";
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
Example 2:

Input: words = ["cat","dog","catdog"]
Output: ["catdog"]


Constraints:

1 <= words.length <= 104
1 <= words[i].length <= 30
words[i] consists of only lowercase English letters.
All the strings of words are unique.
1 <= sum(words[i].length) <= 105
 */

package dsa.leetcode.problems;

import dsa.leetcode.helper.FastReader;
import dsa.leetcode.helper.FastWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P472 {
    Set<String> doesContainWord;
    String[] words;
    int[] dp;

    boolean isConcatenated(String s, int pos) {
        boolean ans = false;
        if (pos == s.length()) {
            return true;
        }
        if (dp[pos] != 0) {
            if (dp[pos] == 1) {
                return false;
            } else if (dp[pos] == 2) {
                return true;
            }
        }
        for (int i = pos; i < s.length(); i++) {
            if (doesContainWord.contains(s.substring(pos, i + 1))) {
                ans |= isConcatenated(s, i + 1);
            }
        }
        if (ans) {
            dp[pos] = 2;
        } else {
            dp[pos] = 1;
        }
        return ans;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        doesContainWord = new HashSet<>();
        this.words = words;
        for (String s : words) {
            doesContainWord.add(s);
        }
        List<String> ans = new ArrayList<>();
        for (String s : words) {
            dp = new int[s.length() + 1];
            doesContainWord.remove(s);
            if (isConcatenated(s, 0)) {
                ans.add(s);
            }
            doesContainWord.add(s);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        FastWriter writer = new FastWriter();
        P472 p472 = new P472();
        int testCases = 1;
        while (testCases-- > 0) {
            // write output commands here
            int n = reader.nextInt();
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = reader.nextLine();
            }
            List<String> ans = p472.findAllConcatenatedWordsInADict(words);
            for (String s : ans) {
                writer.println(s);
            }
        }
        writer.close();
    }
}
