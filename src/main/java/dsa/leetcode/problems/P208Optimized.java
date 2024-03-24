package dsa.leetcode.problems;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P208Optimized {

    private static class TrieNode {
        public List<TrieNode> children;
        public int val;
        public boolean isEnd;
        Map<Integer, TrieNode> valToTrieNodeMap;

        TrieNode(List<TrieNode> child, int val) {
            this.children = child;
            this.val = val;
            this.isEnd = false;
            this.valToTrieNodeMap = new HashMap<>();
        }

    }
    private final TrieNode don;

    public P208Optimized() {
        List<TrieNode> child = new ArrayList<>();
        don = new TrieNode(child, -1);
    }

    public void insert(String word) {
        int n = word.length();
        TrieNode node = don;
        for(int i = 0; i < n; i++) {
            int val = word.charAt(i) - 'a';

            if (node.valToTrieNodeMap.containsKey(val)) {
                node = node.valToTrieNodeMap.get(val);
            } else {
                TrieNode newNode = new TrieNode(new ArrayList<>(), val);
                node.children.add(newNode);
                node.valToTrieNodeMap.put(val, newNode);
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

            if (node.valToTrieNodeMap.containsKey(val)) {
                node = node.valToTrieNodeMap.get(val);
            }
            else {
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
            if (node.valToTrieNodeMap.containsKey(val)) {
                node = node.valToTrieNodeMap.get(val);
            }
            else {
                return false;
            }
        }
        return true;
    }
}
