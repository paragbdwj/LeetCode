/*
107. Binary Tree Level Order Traversal II
Medium

Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
 */
package dsa.leetcode.problems;

import dsa.leetcode.problems.P429.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class P107 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> ans;

    void f(TreeNode node, int level) {
        if (Objects.isNull(node)) {
            return;
        }
        if (ans.size() == level) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(node.val);
        f(node.left, level + 1);
        f(node.right, level + 1);
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ans = new ArrayList<>();
        f(root, 0);
        Collections.reverse(ans);
        return ans;
    }
}
