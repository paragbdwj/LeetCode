/*
2642. Design Graph With Shortest Path Calculator
Hard

There is a directed weighted graph that consists of n nodes numbered from 0 to n - 1. The edges of the graph are initially represented by the given array edges where edges[i] = [fromi, toi, edgeCosti] meaning that there is an edge from fromi to toi with the cost edgeCosti.

Implement the Graph class:

Graph(int n, int[][] edges) initializes the object with n nodes and the given edges.
addEdge(int[] edge) adds an edge to the list of edges where edge = [from, to, edgeCost]. It is guaranteed that there is no edge between the two nodes before adding this one.
int shortestPath(int node1, int node2) returns the minimum cost of a path from node1 to node2. If no path exists, return -1. The cost of a path is the sum of the costs of the edges in the path.


Example 1:


Input
["Graph", "shortestPath", "shortestPath", "addEdge", "shortestPath"]
[[4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]], [3, 2], [0, 3], [[1, 3, 4]], [0, 3]]
Output
[null, 6, -1, null, 6]

Explanation
Graph g = new Graph(4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]);
g.shortestPath(3, 2); // return 6. The shortest path from 3 to 2 in the first diagram above is 3 -> 0 -> 1 -> 2 with a total cost of 3 + 2 + 1 = 6.
g.shortestPath(0, 3); // return -1. There is no path from 0 to 3.
g.addEdge([1, 3, 4]); // We add an edge from node 1 to node 3, and we get the second diagram above.
g.shortestPath(0, 3); // return 6. The shortest path from 0 to 3 now is 0 -> 1 -> 3 with a total cost of 2 + 4 = 6.


Constraints:

1 <= n <= 100
0 <= edges.length <= n * (n - 1)
edges[i].length == edge.length == 3
0 <= fromi, toi, from, to, node1, node2 <= n - 1
1 <= edgeCosti, edgeCost <= 106
There are no repeated edges and no self-loops in the graph at any point.
At most 100 calls will be made for addEdge.
At most 100 calls will be made for shortestPath.
 */
package dsa.leetcode.daily_problems;

import dsa.leetcode.helper.FastReader;
import dsa.leetcode.helper.FastWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// TODO: complete this problem
public class P111123_2642 {
    private final int n;
    private final List[][] adj;

    public P111123_2642(int n, int[][] edges) {
        this.n = n;
        this.adj = new List[n][2]; // adj[i] -> {node[i], weight[i]}
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                adj[i][j] = new ArrayList<Integer>();
            }
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adj[from][0].add(to);
            adj[from][1].add(edge[2]);
        }
    }

    public void addEdge(int[] edge) {
        adj[edge[0]][0].add(edge[1]);
        adj[edge[0]][1].add(edge[2]);
    }

    public int shortestPath(int node1, int node2) {
        Comparator<List<Integer>> comparator = Comparator.comparingInt(list -> list.get(0));
        PriorityQueue<List<Integer>> weightedQueue = new PriorityQueue<>(comparator);  // [{weight[i], node[i]}]
        weightedQueue.add(List.of(0, node1));
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.MAX_VALUE;
        }
        while (!weightedQueue.isEmpty()) {
            List<Integer> node = weightedQueue.poll();
            int sizOfAdjList = adj[node.get(1)].length;
            for (int j = 0; j < sizOfAdjList; j++) {
                if (node.get(0) + (int) adj[node.get(1)][1].get(j) < weight[(int) adj[node.get(1)][0].get(j)]) {
                    weightedQueue.add(List.of(node.get(0) + (int) adj[node.get(1)][1].get(j), (int) adj[node.get(1)][0].get(j)));
                    weight[(int) adj[node.get(1)][0].get(j)] = node.get(0) + (int) adj[node.get(1)][1].get(j);
                }
            }
        }
        return weight[node2] == Integer.MAX_VALUE ? -1 : weight[node2];
    }

    public static void main(String[] args) throws IOException {
            FastReader reader = new FastReader();
            FastWriter writer = new FastWriter();
            int testCases = 1;
            while (testCases-- > 0) {
                // write output commands here
                
            }
            writer.close();
        }
}
