/*
208. Implement Trie (Prefix Tree)
Medium

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There
are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True


Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.
*/

package dsa.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class P208 {

    private static class TrieNode {
        public List<TrieNode> children;
        public int val;
        public boolean isEnd;

        TrieNode(List<TrieNode> child, int val) {
            this.children = child;
            this.val = val;
            this.isEnd = false;
        }
    }

    private final TrieNode don;

    public P208() {
        List<TrieNode> child = new ArrayList<>();
        don = new TrieNode(child, -1);
    }

    public void insert(String word) {
        int n = word.length();
        TrieNode node = don;
        for(int i = 0; i < n; i++) {
            int val = word.charAt(i) - 'a';
            boolean istrue = false;

            for(TrieNode kidNode : node.children) {
                if(kidNode.val == val) {
                    node = kidNode;
                    istrue = true;
                    break;
                }
            }

            if(!istrue) {
                TrieNode newNode = new TrieNode(new ArrayList<>(), val);
                node.children.add(newNode);
                node = newNode;
            }
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        int n = word.length();
        TrieNode node = don;
        for(int i = 0; i < n; i++) {
            int val = word.charAt(i) - 'a';
            boolean istrue = false;

            for(TrieNode kidNode : node.children) {
                if(kidNode.val == val) {
                    node = kidNode;
                    istrue = true;
                    break;
                }
            }

            if(!istrue) {
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TrieNode node = don;
        for(int i = 0; i < n; i++) {
            int val = prefix.charAt(i) - 'a';
            boolean istrue = false;

            for(TrieNode kidNode : node.children) {
                if(kidNode.val == val) {
                    node = kidNode;
                    istrue = true;
                    break;
                }
            }

            if(!istrue) {
                return false;
            }
        }
        return true;
    }
}

/*
Brainstorming :

                        a
                       /
                      p
                     /
                    p
                   /
                  l
                 / \
                e   i
*/