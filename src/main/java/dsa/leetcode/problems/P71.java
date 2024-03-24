/*
71. Simplify Path
Medium

5127

1106

Add to List

Share
Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format
of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.



Example 1:

Input: path = "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
Example 2:

Input: path = "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
Example 3:

Input: path = "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.


Constraints:

1 <= path.length <= 3000
path consists of English letters, digits, period '.', slash '/' or '_'.
path is a valid absolute Unix path.
 */
package dsa.leetcode.problems;

import java.util.List;
import java.util.Stack;

public class P71 {

    public static String simplifyPath(String path) {
        String[] directories= path.split("/");
        Stack<String> stack = new Stack<>();
        for(String s : directories) {
            if(s.equals(".") || s.isEmpty()) {
                continue;
            }
            if(s.equals("..")) {
                if (stack.empty()) {
                    continue;
                }
                stack.pop();
                continue;
            }
            stack.push(s);
        }
        StringBuilder ans = new StringBuilder();
        ans.append("/");
        for(String s : stack) {
            ans.append(s).append("/");
        }
        if(ans.length() > 1) {
            ans.deleteCharAt(ans.length() - 1);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String x = "b/abc/../../a/./c/..";
        simplifyPath(x);
    }
}
