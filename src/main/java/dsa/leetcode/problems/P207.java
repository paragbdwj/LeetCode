/*
207. Course Schedule
Medium


There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are
given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi
first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
So it is impossible.


Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 */

package dsa.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] adj = new ArrayList[numCourses];
        for(int i = 0; i <  numCourses; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        int[] indeg = new int[numCourses];
        for(int[] x : prerequisites) {
            int papa = x[1];
            int beta = x[0];
            adj[papa].add(beta);
            indeg[beta]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i <  numCourses; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }
        int siz = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            List<Integer> childs = adj[x];
            for(int j : childs) {
                if(--indeg[j] == 0) {
                    q.add(j);
                }
            }
            siz++;
        }
        return siz == numCourses;
    }
}
