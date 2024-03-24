/*
105. Construct Binary Tree from Preorder and Inorder Traversal
Medium


Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the
inorder traversal of the same tree, construct and return the binary tree.



Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]


Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
 */
package dsa.leetcode.problems;

import dsa.leetcode.helper.FastReader;
import dsa.leetcode.helper.FastWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class P105 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // inorder -> left root right
    // pre order -> root left right

    Map<Integer, Integer> valueToInNodeIndex;
    int[] preorder;

    TreeNode f(int preLower, int preUpper, int inLower, int inUpper) {
        if (preLower > preUpper) {
            return null;
        }
        int rootVal = preorder[preLower];
        int indexInInorder = valueToInNodeIndex.get(rootVal);
        int leftLen = indexInInorder - inLower;
        int rightLen = inUpper - indexInInorder;
        TreeNode ans = new TreeNode();
        ans.left = f(preLower + 1, preLower + leftLen, inLower, indexInInorder - 1);
        ans.right = f(preLower + leftLen + 1, preUpper, indexInInorder + 1, inUpper);
        ans.val = rootVal;
        return ans;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.valueToInNodeIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueToInNodeIndex.put(inorder[i], i);
        }
        return f(0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        FastWriter writer = new FastWriter();
        int testCases = 1;
        while (testCases-- > 0) {
            // write output commands here
            int n = reader.nextInt();
            P105 p105 = new P105();
            int[] preorder = new int[n], inorder = new int[n];
            for (int i = 0; i < n; i++) {
                preorder[i] = reader.nextInt();
            }
            for (int i = 0; i < n; i++) {
                inorder[i] = reader.nextInt();
            }
            p105.buildTree(preorder, inorder);
        }
        writer.close();
    }
}
