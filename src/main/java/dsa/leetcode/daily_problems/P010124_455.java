/*
455. Assign Cookies

Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j
has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize
the number of your content children and output the maximum number.



Example 1:

Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.
Example 2:

Input: g = [1,2], s = [1,2,3]
Output: 2
Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
You have 3 cookies and their sizes are big enough to gratify all of the children,
You need to output 2.


Constraints:

1 <= g.length <= 3 * 104
0 <= s.length <= 3 * 104
1 <= g[i], s[j] <= 231 - 1
 */
package dsa.leetcode.daily_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class P010124_455 {

        public static void distributeRequests(int n, int m, int[] requests) {
            int[] workloads = new int[n];
            for (int i = 0; i < m; i++) {
                int minWorkload = Integer.MAX_VALUE;
                int minIndex = -1;
                for (int j = 0; j < n; j++) {
                    if (workloads[j] < minWorkload || (workloads[j] == minWorkload && j < minIndex)) {
                        minWorkload = workloads[j];
                        minIndex = j;
                    }
                }
                System.out.println("Request " + (i + 1) + " with load " + requests[i] + " handled by Server " + (minIndex + 1));
                workloads[minIndex] += requests[i];
            }
        }

        static class State {
            int buy;
            int sell;
            State(int buy, int sell) {
                this.buy=buy;
                this.sell=sell;
            }

        }
    public static long profits(int n, int cost, int[] buy, int[] sell) {
        List<State> states = new ArrayList<>();
        for(int i =0; i < n; i++) {
            states.add(new State(buy[i], sell[i]));
        }
        Collections.sort(states, (o1, o2) -> (o2.sell- o2.buy) - (o1.sell - o1.buy));
        long currCost = cost;
        for(int i = 0; i < n; i++) {
            if(currCost >= states.get(i).buy && (states.get(i).sell - states.get(i).buy > 0)) {
                currCost += states.get(i).sell - states.get(i).buy;
            }
        }
        return currCost - cost;
    }


    public static void main(String[] args) {
           int n = 5;
           int cost = 3;
           int[] buy = {9,1,10,8,9};
           int[] sell = {8,7,8,8,8};
           System.out.println(profits(n, cost, buy, sell));
        }
}

